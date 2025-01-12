package model.enums;

public enum Messages {
    INVALID_LOGIN_DETAILS("Incorrect username or password. Try again."),
    THIS_FIELD_IS_REQUIRED("Please fill out this field."),
    USERNAME_TAKEN("This username is already in use."),
    EMAIL_ALREADY_REGISTERED("This email is linked to an existing account."),
    EMAIL_REQUIREMENTS_NOT_MET("Email must be in the format: example@domain.com."),
    USERNAME_REQUIREMENTS_NOT_MET("Username must be at least 4 characters long and can only contain letters, numbers, and underscores."),
    PASSWORD_REQUIREMENTS_NOT_MET("Password must be at least 8 characters with an uppercase letter and a symbol."),
    PASSWORD_CONFIRMATION_MISMATCH("Password and Confirm Password do not match."),
    ACCOUNT_NOT_FOUND("No account found with the provided details."),
    ACCOUNT_LOCKED("Your account is locked due to multiple failed attempts. Reset your password to regain access."),
    EMAIL_NOT_VERIFIED("Verify your email to access the application."),
    SESSION_EXPIRED("Your session has expired. Please log in again."),
    PASSWORD_RESET_SUCCESSFUL("Your password has been updated. Log in to continue."),
    DOCUMENT_UPLOAD_SUCCESSFUL("Document uploaded successfully."),
    DOCUMENT_UPLOAD_FAILED("Failed to upload the document. Try again."),
    FILE_IS_INVALID("Selected file is invalid."),
    FILE_FORMAT_NOT_SUPPORTED("Unsupported file format. Please upload a valid document."),
    ACCESS_DENIED("You do not have permission to access this section."),
    SEARCH_YIELDED_NO_RESULTS("No matching documents found. Check your search criteria.");
    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
