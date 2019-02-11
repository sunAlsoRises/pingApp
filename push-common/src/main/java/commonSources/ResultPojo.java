package commonSources;

public class ResultPojo<T> {
		private String msg ;
		private T resp ;
		private Integer code;		
		public ResultPojo() {
			super();
			// TODO Auto-generated constructor stub
		}

	public ResultPojo(String msg, T resp, Integer code) {
		this.msg = msg;
		this.resp = resp;
		this.code = code;
	}

	public T getResp() {
		return resp;
	}

	public void setResp(T resp) {
		this.resp = resp;
	}

	public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		
}
