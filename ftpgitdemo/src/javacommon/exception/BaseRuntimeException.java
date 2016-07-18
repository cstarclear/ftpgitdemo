package javacommon.exception;

/**
 * 给系统定义的所有运行时异常类的基类
 * 系统中在各个层中定义的异常类必须从此基础类继承
 * @author： wangwch mailto： <a href="wfun@163.com">wfun@163.com</a>
 * @since 1.0
 */
public class BaseRuntimeException extends RuntimeException {

	public BaseRuntimeException() {
		super();
	}

	public BaseRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseRuntimeException(String message) {
		super(message);
	}

	public BaseRuntimeException(Throwable cause) {
		super(cause);
	}

}
