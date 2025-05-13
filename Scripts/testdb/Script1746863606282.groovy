import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

// 🔑 Thông tin kết nối Database
String dbUrl = 'jdbc:postgresql://tramway.proxy.rlwy.net:16663/railway'
String dbUser = 'postgres' // ví dụ POSTGRES_USER
String dbPassword = 'UJDNNTZeESVXBHsggqjVhPRjjzEUyBNj' // ví dụ POSTGRES_PASSWORD

// ✅ Load PostgreSQL JDBC driver
String driver = 'org.postgresql.Driver'
Class.forName(driver)

// 🔗 Tạo kết nối
Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)
println('✅ Kết nối thành công!')

// 🟢 Tạo statement và thực hiện query
Statement stmt = conn.createStatement()

// 🛠️ Query kiểm tra bảng user (ví dụ lấy 5 dòng đầu tiên)
// 🛠️ Query lấy dữ liệu bảng user
String query = 'SELECT * FROM "user"' // ⚠️ TÊN BẢNG user là keyword trong PostgreSQL, nên nhớ để trong dấu ngoặc kép

ResultSet rs = stmt.executeQuery(query)
// 📝 Duyệt qua kết quả và in ra log
while (rs.next()) {
    int id = rs.getInt('id')
    String username = rs.getString('user')
    String password = rs.getString('password')
    
    println("👉 id: ${id}, user: ${username}, password: ${password}")
}

