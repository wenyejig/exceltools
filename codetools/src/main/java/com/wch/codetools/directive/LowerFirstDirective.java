package com.wch.codetools.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * FreeMarker 的用户自定义指令在逐步改变 它嵌套内容的首字母输出转换为小写形式
 * <p>
 * <b>指令内容</b>
 * </p>
 * <p>
 * 指令参数：无
 * <p>
 * 循环变量：无
 * <p>
 * 指令嵌套内容：是
 */
public class LowerFirstDirective implements TemplateDirectiveModel {
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 检查参数是否传入
		if (!params.isEmpty()) {
			throw new TemplateModelException(
					"This directive doesn't allow parameters.");
		}
		if (loopVars.length != 0) {
			throw new TemplateModelException(
					"This directive  doesn't allow loop variables.");
		}
		// 是否有非空的嵌入内容
		if (body != null) {
			// 执行嵌入体部分，和FTL 中的<#nested>一样，除了
			// 我们使用我们自己的writer 来代替当前的output writer.
			body.render(new LowerCaseFilterWriter(env.getOut()));
		} else {
			throw new RuntimeException("missing body");
		}
	}

	/**
	 * {@link Writer}改变字符流到大写形式， 而且把它发送到另外一个{@link Writer}中。
	 */
	private static class LowerCaseFilterWriter extends Writer {
		private final Writer out;

		LowerCaseFilterWriter(Writer out) {
			this.out = out;
		}

		public void write(char[] cbuf, int off, int len) throws IOException {
			char[] transformedCbuf = new char[len];
			for (int i = 0; i < len; i++) {
				if (i == 0) {
					transformedCbuf[i] = Character.toLowerCase(cbuf[i + off]);
				} else {
					transformedCbuf[i] = cbuf[i + off];
				}
			}

			out.write(cbuf);
		}

		public void flush() throws IOException {
			out.flush();
		}

		public void close() throws IOException {
			out.close();
		}
	}
}
