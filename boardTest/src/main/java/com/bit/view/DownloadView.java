package com.bit.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		File file = (File) model.get("df");
		// 컨트롤러에서 실어준 다운로드할 파일을 봅아 온다

		response.setContentType("application/download;charset=utf-8");
		// 응답객체 response를 통해 응답방식이 download임을 설정한다.
		// 사용할 문자셋이 utf-8일을 설정한다.
		response.setContentLength((int) file.length());
		// 다운로드할(응답할) 파일의 길이를 설정한다.

		String fname = URLEncoder.encode(file.getName(), "utf-8");
		// 다운로드할 파일이 한글일수도 있기 때문에 encoding한다.
		response.setHeader("Content-disposition", "attachment;filename=\"" + fname + "\";");
		// 브라우저한테 다운도르할 파일이름을 알려준다.
		response.setHeader("Content-Transfer-encoding", "binary");
		// 브라우저한테 데이터 전송 방식을 설정한다.

		try {
			OutputStream os = response.getOutputStream();
			// 응답을 위한 stram을 생성한다.
			InputStream is = new FileInputStream(file);
			// 파일의 내용을 메모리로 밁어들이기 위한 stream을 생성한다.

			FileCopyUtils.copy(is, os);
			// 파일복사를 수행한다.(실제로 클라이언트에 파일을 내보내는 역할)
			is.close(); // stream을 닫아준다
			os.flush(); // 버퍼의 내용을 내보낸다.

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
