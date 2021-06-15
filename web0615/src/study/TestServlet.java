package study;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;

//�������� javaEE����� �������� �ؼ� �� ����Ǿ��� �� �����Ƿ�
//�� Ŭ������ �������� ��������!!
public class TestServlet extends HttpServlet{
	//��û�� ���� ������ ó���غ���!! service() �޼��尡 ��û �� ������ ó��
	
	//node.js�� ���������� Ŭ���̾�Ʈ�� �ӿ�û�� ó���Ϸ���, � ��û������ ������ Ŭ���̾�Ʈ��
	//��û�ߴ����� ���� ������ ����, ��û��ü�� �̿��ؾ��Ѵ�!!
	//����� �������̽��� HttpServletRequest ��ü��, ��û�� ���ö� �ڵ� �����Ǿ� ������
	//������ ���� ä�����Ƿ�, �����ڰ� �׳� ���⸸ �ϸ� �ȴ�!!
	//���� ��û�� ���� �������� �� ��Ʈ���� ���� ���䰴ü�� �Ű������� �Ѱܹ޴´�.

	//�� ��û�� ó���ϴ� ���� ���� ��û�� �� ��û�� ���� ��������� ��ī������ �����Ѵ�!!
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html"); //mimetype ����
		response.setCharacterEncoding("utf-8");//��Ʈ���� �̱� ���� �̸� ���ڵ� ó��
		
		PrintWriter out =response.getWriter(); //���ڱ���� ��½�Ʈ���� ��ȯ�ϴ� �޼���!!
		out.print("this is second Servlet!!");
	}
}
