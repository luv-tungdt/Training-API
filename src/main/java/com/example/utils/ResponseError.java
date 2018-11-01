package com.example.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseError {
	
	@JsonProperty("error")
	private String error;
	
	@JsonProperty("error_description")
	private String errorDescription;
	
	
	public ResponseError(String error, String errorDescription) {
		this.error = error;
		this.errorDescription = errorDescription;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	public static ResponseError error_400() {
		return new ResponseError("400",
				"Thiếu thông số bắt buộc, giá trị không hợp lệ hoặc request không đúng định dạng");
	}
	
	public static ResponseError error_404() {
		return new ResponseError("404", "Cố gắng thao tác một tài nguyên không tồn tại");
	}
	
	public static ResponseError error_500() {
		return new ResponseError("500", "Một lỗi xảy ra ở phía máy chủ");
	}
	
}
