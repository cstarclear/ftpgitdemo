package javacommon.exception;

/**
 * @author： wangwch  mailto： <a href="wfun@163.com">wfun@163.com</a>
 * @since 1.1
 */
public class DaoException extends BaseRuntimeException {

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause) {
		super("Dao层异常: " + message, cause);
	}

	public DaoException(String message) {
		super("Dao层异常: " + message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
