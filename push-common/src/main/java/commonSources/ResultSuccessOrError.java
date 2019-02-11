package commonSources;

public  class ResultSuccessOrError {
	public static void resultSuccess(ResultPojo rp){
		rp.setCode(200);
		rp.setMsg("success");
	}
	public static void resultError(ResultPojo rp){
		rp.setCode(100);
		rp.setMsg("error");
	}
}
