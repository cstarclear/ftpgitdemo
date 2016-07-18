package javacommon.exception;

/**
 * 应用层异常
 * @author： wangwch  mailto： <a href="wfun@163.com">wfun@163.com</a>
 * @since 1.1
 */
public class ServiceException extends BaseRuntimeException {

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super("系统提示: " + message, cause);
	}

	public ServiceException(String message) {
		super("系统提示: " + message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
