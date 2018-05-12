package com.babasport.core.service.staticpage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 静态化
 * 
 * @author xushy
 *
 */
public class StaticPageServiceImpl implements StaticPageService, ServletContextAware {
	// 声明注入configuration
	private Configuration conf;
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.conf = freeMarkerConfigurer.getConfiguration();
	}

	// 获取全路径
	private String getPath(String name) {
		return servletContext.getRealPath(name);
	}
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	// 静态化商品 ActiveMQ发送过来的id
	public void productStaticPage(Map<String, Object> root, String id) {
		// 静态化页面输出的路径
		String path = getPath("/html/product/" + id + ".html");
		File file = new File(path);
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}

		Writer out = null;
		try {
			// 加载指定模板
			Template template = conf.getTemplate("product.html");
			// 输出
			out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			template.process(root, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 静态化订单
}
