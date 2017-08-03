package objectRepository;

public interface iCustomer {
	String id_LoginPageElements = "co.jakapp.customer:id/input_username_login,co.jakapp.customer:id/splash_button_facebook,co.jakapp.customer:id/splash_button_google,co.jakapp.customer:id/splash_button_sign_in";
	String id_LoginPageEnterEmailTB = "co.jakapp.customer:id/input_username_login";
	String id_LoginPageFacebookBtn = "co.jakapp.customer:id/splash_button_facebook";
	String id_LoginPageGoogleBtn = "co.jakapp.customer:id/splash_button_google";
	String id_LoginPageCreateAccountLink = "co.jakapp.customer:id/splash_button_sign_in";
	String id_SignupScrHeader = "co.jakapp.customer:id/toolbar_title";
	String id_FacebookLoginPageLayout = "com.facebook.katana:id/login_root";
	String id_GooglePopupTitle = "com.google.android.gms:id/title";
	String id_ForgotPwdScrEmailTB = "co.jakapp.customer:id/email_et";
	String id_ForgotPwdScrPhoneTB = "co.jakapp.customer:id/phone_number_et";
	String id_ForgotPwdScrEmailLbl = "co.jakapp.customer:id/email_radio_btn";
	String id_ForgotPwdScrSMSLbl = "co.jakapp.customer:id/sms_radio_btn";
	String id_ForgotPwdScrSendBtn = "co.jakapp.customer:id/reset_btn";
	String id_ForgotPwdScrValidationMsgs = "co.jakapp.customer:id/snackbar_text";
	String id_ResetPasswordPwdResetCodeTB = "co.jakapp.customer:id/reset_code_et";
	String id_ResetPasswordPwdNewPwdTB = "co.jakapp.customer:id/new_password_et";
	String id_ResetPasswordPwdConfirmPwdTB = "co.jakapp.customer:id/confirm_password_et";
	
	String id_FacebookAppLoginScrUsernameTB = "com.facebook.katana:id/login_username";
	String id_FacebookAppLoginScrPasswordTB = "com.facebook.katana:id/login_password";
	String id_FacebookAppLoginScrLoginBtn = "com.facebook.katana:id/login_login";
	
	String className_LoginPageLogo = "android.widget.ImageView";
	
	
	String value_InvalidEmailID = "test@gmail.com";
	String value_Password = "mind@123";
	
	String validationMsg_ResetPasswordPwdLength = "Password length must be more than 8 characters";
	String validationMsg_ResetPasswordResetPwdCodeEmptyTB = "Reset password code can not be empty";
	String validationMsg_ForgotPwdScrNonExistEmailID = "email is invalid";
	String validationMsg_ForgotPwdScrInvalidEmailID = "Invalid email address";
	String validationMsg_ResetPasswordPwdMatching = "Password confirmation must match Password";
	String validationMsg_ResetPasswordInvalidToken = "Password token is invalid";
	String validationMsg_ResetPasswordPwdResetsuccessfully = "Password reset successfully";
	
}
