package cn.scau;

import static org.junit.Assert.assertNotNull;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import cn.binarywang.tools.generator.EmailAddressGenerator;
import cn.binarywang.tools.generator.bank.BankCardNumberGenerator;
import cn.binarywang.tools.generator.bank.BankCardTypeEnum;
import cn.binarywang.tools.generator.bank.BankNameEnum;
import cn.scau.service.ReservationService;

public class TestRSVSendMail extends BaseTest {

	@Autowired
	ReservationService rsv;
	
	
	
	@Test
	public void test() throws Exception{
		   
		 String generatedEmail = EmailAddressGenerator.getInstance().generate();
	        System.out.println(generatedEmail);
	        assertNotNull(generatedEmail);
		    
	}
}
