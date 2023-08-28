<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>
                    <label>First operand</label>
                </td>
                <td>
                    <input type="text" name="firstNumber" placeholder="Enter your number1">
                </td>
            </tr>
            <tr>
                <td><label>Operator</label></td>
                <td>
                    <select name="operator">
                        <option value='+'>Addition</option>
                        <option value='-'>Subtraction</option>
                        <option value='*'>multiplication</option>
                        <option value='/'>division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Second operand</label></td>
                <td><input type="text" name="secondNumber" placeholder="Enter your number2"></td>
            </tr>
            <tr>
                <td><input type="Submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>
${error}

</body>
</html>