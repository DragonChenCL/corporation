package com.itdage.util;/**
 * Created by huayu on 2018/12/4.
 */

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName MyHttpUtil
 * @Description Http请求相关的工具类
 * @Author huayu
 * @Date 2018/12/4 14:41
 * @Version 1.0
 **/
@Component
public class MyHttpUtil {

    private Logger logger = LoggerFactory.getLogger(MyHttpUtil.class);

    /**
     * @description
     * @author response返回json数据
     * @date 2018/12/4
     * @param
     * @return void
     */
    public void responseOutWithJson(Map<String, Object> map,HttpServletResponse response){
        String json = new Gson().toJson(map);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(json);
            logger.debug("返回是\n" + json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
