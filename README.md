# spring-boot-pattern-validation-example
This project is spring boot application that implements custom validator annotations ot validate dates and emails more restrictively.

## Sample Requests
### Date Validation
1. Valid dates:
   - 2012-12-13T12:12:59
     - http://localhost:8080/validate/date?strDate=2012-12-13T12:12:59
     
2. Invalid Dates:
   - 2012-2-13T12:12:59
     - http://localhost:8080/validate/date?strDate=2012-2-13T12:12:59
   - 2012-12-13T12:12:60
     - http://localhost:8080/validate/date?strDate=2012-12-13T12:12:60

1. Valid Emails
   - test.west@test.org
     - http://localhost:8080/validate/email?strEmail=test.west@test.org
3. Invalid Dates:
   - test.west@test
     - http://localhost:8080/validate/email?strEmail=test.west@test


[^1]: My reference.
[^2]: Every new line should be prefixed with 2 spaces.  
  This allows you to have a footnote with multiple lines.
[^note]:
    Named footnotes will still render with numbers instead of the text but allow easier identification and linking.  
    This footnote also has been made with a different syntax using 4 spaces for new lines.
