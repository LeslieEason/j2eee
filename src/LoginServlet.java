import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("UTF-8");//设置返回的格式
        String html = null;
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String []hobbies=req.getParameterValues("hobbies");//得到name都为hobbies的所有控件参数
        System.out.println("账户："+name+"密码："+password+"爱好1"+hobbies[0]+"爱好2"+hobbies[1]);
        Map<String,String[]> parameters=req.getParameterMap();//使用一个map来存放所有的参数，其中key为name，value为输出值
        Set<String> paraNames=parameters.keySet();//使用一个set拿到所有的key
        for (String param:paraNames)//使用key来遍历map，并通过key访问map
        {
            String []value=parameters.get(param);
            System.out.println(param+":"+ Arrays.asList(value));
        }
        Enumeration<String> headerNames =req.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String header=headerNames.nextElement();
            String value=req.getHeader(header);
            System.out.printf("%s\t%s%n",header,value);
        }
        //resp.setContentType("text/lol");
        if ("admin".equals(name) && "123".equals(password))
            req.getRequestDispatcher("success.html").forward(req,resp);
            //html = "<div style='color:green'>success</div>";
        else
            resp.sendRedirect("failed.html");
            //html = "<div style='color:red'>failed</div>";
//        PrintWriter pw = resp.getWriter();
//        pw.println(html);
    }
}
