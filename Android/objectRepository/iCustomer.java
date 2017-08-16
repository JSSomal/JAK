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
	String id_ResetPasswordPwdIAlreadyHaveResetCodeLink = "co.jakapp.customer:id/have_code_tv";
	String id_LoginPageEnterPasswordTB = "co.jakapp.customer:id/input_pass_login";
	String id_LandingScrTitle = "co.jakapp.customer:id/toolbar_title";
	String id_SignupScrPasswordNextIcon = "co.jakapp.customer:id/submit_pass_login";
	
	String id_FacebookAppLoginScrUsernameTB = "com.facebook.katana:id/login_username";
	String id_FacebookAppLoginScrPasswordTB = "com.facebook.katana:id/login_password";
	String id_FacebookAppLoginScrLoginBtn = "com.facebook.katana:id/login_login";
	String id_FacebookAppLocationAccessPopupDenyBtn = "com.facebook.katana:id/button2";
	String id_FacebookAppRememPaswrdPopupNotNowBtn = "com.facebook.katana:id/dbl_off";
	String facebook_Package = "com.facebook.katana";
	String facebook_Activity = "com.facebook.katana.LoginActivity";
	String facebook_Username = "testing.gsingh13@gmail.com";
	String facebook_Password = "mind@123";
	
	String id_MessageAppFirstMsgContent = "com.google.android.apps.messaging:id/conversation_snippet";
	
	String className_LoginPageLogo = "android.widget.ImageView";
	String className_LandingScrMenuIcon = "android.widget.ImageButton";
	
	String value_InvalidEmailID = "test@gmail.com";
	
	String value_Password = "mind@123";
	String value_InvalidPhoneNo = "545435454544";
	
	String validationMsg_ResetPasswordPwdLength = "Password length must be more than 8 characters";
	String validationMsg_ResetPasswordResetPwdCodeEmptyTB = "Reset password code can not be empty";
	String validationMsg_ForgotPwdScrNonExistEmailID = "email is invalid";
	String validationMsg_ForgotPwdScrInvalidEmailID = "Invalid email address";
	String validationMsg_ResetPasswordPwdMatching = "Password confirmation must match Password";
	String validationMsg_ResetPasswordInvalidToken = "Password token is invalid";
	String validationMsg_ResetPasswordPwdResetsuccessfully = "Password reset successfully";
	String validationMsg_ResetPasswordPwdEmptyPhone = "Phone can not be empty";
	String validationMsg_ResetPasswordPwdInvalidPhoneNo = "phone is invalid";
	String validationMsg_LoginPageWrongPassword = "Login is invalid";

	//---------------------- Registeration Screen
	
	
	String value_SignupScreenNameField = "Testqa";
	
	String value_SignupScreenvalidEmail1 = "Testqa@yopmail.com";
	String value_SignupScreenvalidEmail2 = "Testqa1@yopmail.com";
	String value_SignupScreenvalidPassword = "1234567890";
	
	String value_SignupScreenValidPhone1 = "8699494378";
	String value_SignupScreenValidPhone2 = "8799494393";
	String value_SignupScreenInvalidOTP = "0000";
	
	String id_VerifyPhoneScreenEnterCodeField = "co.jakapp.customer:id/input_code1_new_otp";
	
	String xpath_VerifyPhoneScreenPhoneFailedValidation = "//android.widget.TextView[@text='Phone verification failed']";
	
	String xpath_HomeScreenTitleText = "//co.jakapp.customer:id/toolbar_title[@text='New request']";
	String class_HomeScreenMenuIcon = "android.widget.ImageButton";
	String xpath_HomeScreenMenuIconLogout = "//android.widget.CheckedTextView[@text='LOGOUT']";
	
	String id_VerifyPhoneScreenResendOTPLink = "co.jakapp.customer:id/send_via_sms_new_otp";
	String id_SignupScreenSignupButton = "co.jakapp.customer:id/btn_sign_up";
	String xpath_SignupScreenNameFieldValidation = "//android.widget.TextView[@text='Name can not be empty']";
	String id_SignupScreenNameField = "co.jakapp.customer:id/location_name_et";
	
	String id_SignupScreenEmailField = "co.jakapp.customer:id/email_et";
	String value_SignupScreenInvalidEmail = "Test@";
	
	
	
	String xpath_SignupScreenEmailFieldValidation = "//android.widget.TextView[@text='Invalid email address']";
	String xpath_SignupScreenPasswordFieldValidation = "//android.widget.TextView[@text='Password length must be more than 8 characters']";
	
	String id_SignupScreenPasswordField = "co.jakapp.customer:id/password_et";
	String value_SignupScreenInvalidPassword = "12345";
	
	
	String id_SignupScreenCountryDDL = "co.jakapp.customer:id/country_code_tv";
	String xpath_SignupScreenCountryDDLTitle = "//android.widget.TextView[@text='Select your country']";
	
	String value_SignupScreenCountryName = "Zambia";
	
	String xpath_SignupScreenCountryDDLSelect = "//android.widget.TextView[@text='"+value_SignupScreenCountryName+"']";
	
	String xpath_SignupScreenPhoneFieldValidation = "//android.widget.TextView[@text='Please enter valid phone number']";
	String xpath_SignupScreenInvalidPhoneValidation = "//android.widget.TextView[@text='The mobile number is invalid']";
	String xpath_SignupScreenDuplicatePhoneValidation = "//android.widget.TextView[@text='Phone number has been used']";
	
	//String xpath_SignupScreenDuplicateEmailValidation = "//android.widget.TextView[@text='']";
	
	String id_SignupScreenPhonedField = "co.jakapp.customer:id/phone_number_et";
	String value_SignupScreenInvalidPhone = "1111111111";
	String value_SignupScreenDuplicatePhone = "8054520616";
	
}
