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
		// ��Ʈ�ѷ����� �Ǿ��� �ٿ�ε��� ������ ���� �´�

		response.setContentType("application/download;charset=utf-8");
		// ���䰴ü response�� ���� �������� download���� �����Ѵ�.
		// ����� ���ڼ��� utf-8���� �����Ѵ�.
		response.setContentLength((int) file.length());
		// �ٿ�ε���(������) ������ ���̸� �����Ѵ�.

		String fname = URLEncoder.encode(file.getName(), "utf-8");
		// �ٿ�ε��� ������ �ѱ��ϼ��� �ֱ� ������ encoding�Ѵ�.
		response.setHeader("Content-disposition", "attachment;filename=\"" + fname + "\";");
		// ���������� �ٿ���� �����̸��� �˷��ش�.
		response.setHeader("Content-Transfer-encoding", "binary");
		// ���������� ������ ���� ����� �����Ѵ�.

		try {
			OutputStream os = response.getOutputStream();
			// ������ ���� stram�� �����Ѵ�.
			InputStream is = new FileInputStream(file);
			// ������ ������ �޸𸮷� ������̱� ���� stream�� �����Ѵ�.

			FileCopyUtils.copy(is, os);
			// ���Ϻ��縦 �����Ѵ�.(������ Ŭ���̾�Ʈ�� ������ �������� ����)
			is.close(); // stream�� �ݾ��ش�
			os.flush(); // ������ ������ ��������.

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
