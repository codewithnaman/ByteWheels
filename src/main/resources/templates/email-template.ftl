<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<style TYPE="text/css">
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#78ab46" style="padding: 40px 0 30px 0;">
            <img src="cid:logo.png" alt="https://bytewheels.com" style="display: block;"/>
        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
            <p>Dear ${orderResponseDetails.getCustomerFirstName()},</p>
            <p>Thanks for your booking, your booking details are</p>
            <p>
            <table style="width:100%" align="left">
                <tr>
                    <th>Order ID</th>
                    <th>${orderResponseDetails.getOrderId()}</th>
                </tr>
                <tr>
                    <th>Car Name</th>
                    <th>${orderResponseDetails.getCarName()}</th>
                </tr>
                <tr>
                    <th>Car Category</th>
                    <th>${orderResponseDetails.getCarCategory()}</th>
                </tr>
                <tr>
                    <th>Car Description</th>
                    <th>${orderResponseDetails.getCarDescription()}</th>
                </tr>
                <tr>
                    <th>Car Regitration Number to Pickup</th>
                    <th>${orderResponseDetails.getAllocatedCarRegistrationNumber()}</th>
                </tr>
                <tr>
                    <th>From Date</th>
                    <th>${orderResponseDetails.getFromDate()}</th>
                </tr>
                <tr>
                    <th>To Date</th>
                    <th>${orderResponseDetails.getToDate()}</th>
                </tr>
                <tr>
                    <th>Total Amount Due</th>
                    <th>${orderResponseDetails.getTotalAmount()}</th>
                </tr>
            </table>
            </p>

        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;"><p>Thanks</p>
            <p>ByteWheels</p></td>
    </tr>
    <tr>
        <td bgcolor="#777777" style="padding: 30px 30px 30px 30px;">
            <p></p>
            <p></p>
        </td>
    </tr>
</table>

</body>
</html>