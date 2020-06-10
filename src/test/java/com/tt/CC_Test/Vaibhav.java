package com.tt.CC_Test;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Vaibhav 
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><?Label MBSQA1|RESERVATION|3408db19-6ef5-426b-b970-28ac79a97845|NEW?><Reservation xmlns=\"reservation.fidelio.5.0\" xmlns:ns2=\"profile.fidelio.5.0\" xmlns:ns3=\"ecertificate.fidelio.1.0\" xmlns:ns4=\"udfdefinition.fidelio.2.0\" xmlns:ns5=\"udf.fidelio.2.0\" xmlns:ns6=\"relationship.fidelio.3.0\" mfReservationAction=\"ADD\" mfShareAction=\"NA\">\r\n" + 
				"    <HotelReference>\r\n" + 
				"        <hotelCode>MBSQA1</hotelCode>\r\n" + 
				"    </HotelReference>\r\n" + 
				"    <confirmationID>MBSQA1102767489</confirmationID>\r\n" + 
				"    <reservationOriginatorCode>REZTRIP</reservationOriginatorCode>\r\n" + 
				"    <mfLegNumbers>0</mfLegNumbers>\r\n" + 
				"    <originalBookingDate>2019-04-04T01:30:23.388+08:00</originalBookingDate>\r\n" + 
				"    <StayDateRange timeUnitType=\"DAY\">\r\n" + 
				"        <startTime>2019-04-10T15:00:00.000-04:00</startTime>\r\n" + 
				"        <numberOfTimeUnits>3</numberOfTimeUnits>\r\n" + 
				"    </StayDateRange>\r\n" + 
				"    <GuestCounts>\r\n" + 
				"        <GuestCount>\r\n" + 
				"            <ageQualifyingCode>ADULT</ageQualifyingCode>\r\n" + 
				"            <mfCount>1</mfCount>\r\n" + 
				"        </GuestCount>\r\n" + 
				"        <GuestCount>\r\n" + 
				"            <ageQualifyingCode>CHILD</ageQualifyingCode>\r\n" + 
				"            <mfCount>0</mfCount>\r\n" + 
				"        </GuestCount>\r\n" + 
				"    </GuestCounts>\r\n" + 
				"    <ResComments>\r\n" + 
				"        <ResComment>\r\n" + 
				"            <resCommentRPH>0</resCommentRPH>\r\n" + 
				"            <commentOriginatorCode>REZTRIP</commentOriginatorCode>\r\n" + 
				"            <guestViewable>false</guestViewable>\r\n" + 
				"            <comment>RESERVATION \r\n" + 
				"Nightly Room Rate: RO (04/10 @ 419.00 ), RO (04/11 @ 399.00 ), RO (04/12 @ 439.00 )\r\n" + 
				"BE Transaction ID: S13619900000000010000001000000 \r\n" + 
				"BE Amount: 1257.00 \r\n" + 
				"Currency Code: SGD \r\n" + 
				"FX Rate: 1.000000 \r\n" + 
				"No of Room: 1 \r\n" + 
				"Total BE Amount: 1479.48 \r\n" + 
				"</comment>\r\n" + 
				"            <mfcommentType>RESERVATION</mfcommentType>\r\n" + 
				"        </ResComment>\r\n" + 
				"        <ResComment>\r\n" + 
				"            <resCommentRPH>1</resCommentRPH>\r\n" + 
				"            <commentOriginatorCode>REZTRIP</commentOriginatorCode>\r\n" + 
				"            <guestViewable>false</guestViewable>\r\n" + 
				"            <comment>PAYMENT \r\n" + 
				"Order Reference Number (ORN): S13619900000000010000001000000 \r\n" + 
				"Card Type: MasterCard \r\n" + 
				"Tokenized Card Number: 2223007776370007 \r\n" + 
				"Currency Code: SGD \r\n" + 
				"Transaction Date and Time: 2019-04-04 01:30 AM \r\n" + 
				"Cardholder Name: fghj \r\n" + 
				"</comment>\r\n" + 
				"            <mfcommentType>RESERVATION</mfcommentType>\r\n" + 
				"        </ResComment>\r\n" + 
				"    </ResComments>\r\n" + 
				"    <ResCreditCards>\r\n" + 
				"        <ResCreditCard reservationActionType=\"NEW\">\r\n" + 
				"            <ns2:CreditCard>\r\n" + 
				"                <ns2:creditCardCode>MC-ONLINE</ns2:creditCardCode>\r\n" + 
				"            </ns2:CreditCard>\r\n" + 
				"            <resCreditCardRPH>0</resCreditCardRPH>\r\n" + 
				"        </ResCreditCard>\r\n" + 
				"    </ResCreditCards>\r\n" + 
				"    <ResGuests>\r\n" + 
				"        <ResGuest reservationActionType=\"NEW\">\r\n" + 
				"            <resGuestRPH>0</resGuestRPH>\r\n" + 
				"            <profileRPHs>0</profileRPHs>\r\n" + 
				"            <InHouseTimeSpan timeUnitType=\"DAY\">\r\n" + 
				"                <startTime>2019-04-10T15:00:00.000-04:00</startTime>\r\n" + 
				"                <numberOfTimeUnits>3</numberOfTimeUnits>\r\n" + 
				"            </InHouseTimeSpan>\r\n" + 
				"            <arrivalTime>2019-04-10T03:00:00.000-04:00</arrivalTime>\r\n" + 
				"            <confirmationID>MBSQA1102767489</confirmationID>\r\n" + 
				"            <mfConfirmationLegNo>0</mfConfirmationLegNo>\r\n" + 
				"            <ReservationReferences>\r\n" + 
				"                <ReservationReference referenceNumber=\"S13619900000000010000001000000\" type=\"TA_RECORD_LOCATOR\"/>\r\n" + 
				"            </ReservationReferences>\r\n" + 
				"        </ResGuest>\r\n" + 
				"    </ResGuests>\r\n" + 
				"    <ResProfiles>\r\n" + 
				"        <ResProfile>\r\n" + 
				"            <ns2:Profile gender=\"UNKNOWN\" profileType=\"GUEST\">\r\n" + 
				"                <ns2:creatorCode>REZTRIP</ns2:creatorCode>\r\n" + 
				"                <ns2:createdDate>2019-04-03T13:30:26.523-04:00</ns2:createdDate>\r\n" + 
				"                <ns2:lastUpdaterCode>REZTRIP</ns2:lastUpdaterCode>\r\n" + 
				"                <ns2:lastUpdated>2019-04-03T13:30:26.523-04:00</ns2:lastUpdated>\r\n" + 
				"                <ns2:genericName>ttqa</ns2:genericName>\r\n" + 
				"                <ns2:IndividualName>\r\n" + 
				"                    <ns2:namePrefix>Mr.</ns2:namePrefix>\r\n" + 
				"                    <ns2:nameFirst>test</ns2:nameFirst>\r\n" + 
				"                    <ns2:nameSur>ttqa</ns2:nameSur>\r\n" + 
				"                </ns2:IndividualName>\r\n" + 
				"                <ns2:primaryLanguageID>en</ns2:primaryLanguageID>\r\n" + 
				"                <ns2:ElectronicAddresses>\r\n" + 
				"                    <ns2:ElectronicAddress electronicAddressType=\"EMAIL\">\r\n" + 
				"                        <ns2:eAddress>ttqa@traveltripper.com</ns2:eAddress>\r\n" + 
				"                    </ns2:ElectronicAddress>\r\n" + 
				"                </ns2:ElectronicAddresses>\r\n" + 
				"                <ns2:PostalAddresses>\r\n" + 
				"                    <ns2:PostalAddress addressType=\"BILLING\">\r\n" + 
				"                        <ns2:countryCode>IN</ns2:countryCode>\r\n" + 
				"                    </ns2:PostalAddress>\r\n" + 
				"                </ns2:PostalAddresses>\r\n" + 
				"                <ns2:PhoneNumbers>\r\n" + 
				"                    <ns2:PhoneNumber>\r\n" + 
				"                        <ns2:phoneNumber>911234567</ns2:phoneNumber>\r\n" + 
				"                        <ns2:mfPrimaryYN>Y</ns2:mfPrimaryYN>\r\n" + 
				"                    </ns2:PhoneNumber>\r\n" + 
				"                </ns2:PhoneNumbers>\r\n" + 
				"                <ns2:mfResort>MBSQA1</ns2:mfResort>\r\n" + 
				"                <ns2:PrivacyOption>\r\n" + 
				"                    <ns2:mfAllowMail>N</ns2:mfAllowMail>\r\n" + 
				"                    <ns2:mfAllowEMail>N</ns2:mfAllowEMail>\r\n" + 
				"                    <ns2:mfAllowPhone>false</ns2:mfAllowPhone>\r\n" + 
				"                    <ns2:mfAllowSMS>false</ns2:mfAllowSMS>\r\n" + 
				"                    <ns2:mfAllowHistory>false</ns2:mfAllowHistory>\r\n" + 
				"                    <ns2:mfAllowMarketResearch>false</ns2:mfAllowMarketResearch>\r\n" + 
				"                    <ns2:mfAllowThirdParty>false</ns2:mfAllowThirdParty>\r\n" + 
				"                </ns2:PrivacyOption>\r\n" + 
				"            </ns2:Profile>\r\n" + 
				"            <resProfileRPH>0</resProfileRPH>\r\n" + 
				"        </ResProfile>\r\n" + 
				"    </ResProfiles>\r\n" + 
				"    <RoomStays>\r\n" + 
				"        <RoomStay mfReservationAction=\"ADD\" reservationActionType=\"NEW\" reservationStatusType=\"RESERVED\">\r\n" + 
				"            <roomStayRPH>0</roomStayRPH>\r\n" + 
				"            <roomInventoryCode>DTN</roomInventoryCode>\r\n" + 
				"            <TimeSpan timeUnitType=\"DAY\">\r\n" + 
				"                <startTime>2019-04-10T00:00:00.000-04:00</startTime>\r\n" + 
				"                <numberOfTimeUnits>3</numberOfTimeUnits>\r\n" + 
				"            </TimeSpan>\r\n" + 
				"            <RatePlans>\r\n" + 
				"                <RatePlan reservationActionType=\"NEW\">\r\n" + 
				"                    <ratePlanRPH>0</ratePlanRPH>\r\n" + 
				"                    <ratePlanCode>TDBOOK</ratePlanCode>\r\n" + 
				"                    <TimeSpan timeUnitType=\"DAY\">\r\n" + 
				"                        <startTime>2019-04-10T00:00:00.000-04:00</startTime>\r\n" + 
				"                        <numberOfTimeUnits>3</numberOfTimeUnits>\r\n" + 
				"                    </TimeSpan>\r\n" + 
				"                    <mfMarketCode>TEST</mfMarketCode>\r\n" + 
				"                    <Rates>\r\n" + 
				"                        <Rate rateBasisTimeUnitType=\"DAY\" reservationActionType=\"NEW\">\r\n" + 
				"                            <rateRPH>0</rateRPH>\r\n" + 
				"                            <Amount currencyCode=\"SGD\">\r\n" + 
				"                                <valueNum>419.0</valueNum>\r\n" + 
				"                            </Amount>\r\n" + 
				"                            <rateBasisUnits>1</rateBasisUnits>\r\n" + 
				"                            <TimeSpan>\r\n" + 
				"                                <startTime>2019-04-10T00:00:00.000-04:00</startTime>\r\n" + 
				"                                <numberOfTimeUnits>1</numberOfTimeUnits>\r\n" + 
				"                            </TimeSpan>\r\n" + 
				"                            <mfAdults>1</mfAdults>\r\n" + 
				"                            <mfChildren>0</mfChildren>\r\n" + 
				"                            <mfsourceCode>RezTripWeb</mfsourceCode>\r\n" + 
				"                            <mfMarketCode>TEST</mfMarketCode>\r\n" + 
				"                            <rateRoomType>DTN</rateRoomType>\r\n" + 
				"                        </Rate>\r\n" + 
				"                        <Rate rateBasisTimeUnitType=\"DAY\" reservationActionType=\"NEW\">\r\n" + 
				"                            <rateRPH>1</rateRPH>\r\n" + 
				"                            <Amount currencyCode=\"SGD\">\r\n" + 
				"                                <valueNum>399.0</valueNum>\r\n" + 
				"                            </Amount>\r\n" + 
				"                            <rateBasisUnits>1</rateBasisUnits>\r\n" + 
				"                            <TimeSpan>\r\n" + 
				"                                <startTime>2019-04-11T00:00:00.000-04:00</startTime>\r\n" + 
				"                                <numberOfTimeUnits>1</numberOfTimeUnits>\r\n" + 
				"                            </TimeSpan>\r\n" + 
				"                            <mfAdults>1</mfAdults>\r\n" + 
				"                            <mfChildren>0</mfChildren>\r\n" + 
				"                            <mfsourceCode>RezTripWeb</mfsourceCode>\r\n" + 
				"                            <mfMarketCode>TEST</mfMarketCode>\r\n" + 
				"                            <rateRoomType>DTN</rateRoomType>\r\n" + 
				"                        </Rate>\r\n" + 
				"                        <Rate rateBasisTimeUnitType=\"DAY\" reservationActionType=\"NEW\">\r\n" + 
				"                            <rateRPH>2</rateRPH>\r\n" + 
				"                            <Amount currencyCode=\"SGD\">\r\n" + 
				"                                <valueNum>439.0</valueNum>\r\n" + 
				"                            </Amount>\r\n" + 
				"                            <rateBasisUnits>1</rateBasisUnits>\r\n" + 
				"                            <TimeSpan>\r\n" + 
				"                                <startTime>2019-04-12T00:00:00.000-04:00</startTime>\r\n" + 
				"                                <numberOfTimeUnits>1</numberOfTimeUnits>\r\n" + 
				"                            </TimeSpan>\r\n" + 
				"                            <mfAdults>1</mfAdults>\r\n" + 
				"                            <mfChildren>0</mfChildren>\r\n" + 
				"                            <mfsourceCode>RezTripWeb</mfsourceCode>\r\n" + 
				"                            <mfMarketCode>TEST</mfMarketCode>\r\n" + 
				"                            <rateRoomType>DTN</rateRoomType>\r\n" + 
				"                        </Rate>\r\n" + 
				"                    </Rates>\r\n" + 
				"                    <mfsourceCode>RezTripWeb</mfsourceCode>\r\n" + 
				"                </RatePlan>\r\n" + 
				"            </RatePlans>\r\n" + 
				"            <resGuestRPHs>0</resGuestRPHs>\r\n" + 
				"            <GuaranteeInfo guaranteeType=\"DEPOSIT\">\r\n" + 
				"                <mfGuaranteeType>DEPOSIT</mfGuaranteeType>\r\n" + 
				"                <resCreditCardRPH>0</resCreditCardRPH>\r\n" + 
				"                <resProfileRPH>0</resProfileRPH>\r\n" + 
				"                <GuaranteeDeposit/>\r\n" + 
				"            </GuaranteeInfo>\r\n" + 
				"            <PaymentInstructions>\r\n" + 
				"                <PaymentInstruction paymentMethodType=\"CREDITCARD\">\r\n" + 
				"                    <mfPaymentMethod>MC-ONLINE</mfPaymentMethod>\r\n" + 
				"                    <resCreditCardRPH>0</resCreditCardRPH>\r\n" + 
				"                </PaymentInstruction>\r\n" + 
				"            </PaymentInstructions>\r\n" + 
				"            <mfsourceCode>RezTripWeb</mfsourceCode>\r\n" + 
				"            <mfchannelCode>RWB</mfchannelCode>\r\n" + 
				"        </RoomStay>\r\n" + 
				"    </RoomStays>\r\n" + 
				"    <SpecialRequests>\r\n" + 
				"        <SpecialRequest mfSpecialRequestType=\"PRS\" reservationActionType=\"NEW\">\r\n" + 
				"            <specialRequestRPH>0</specialRequestRPH>\r\n" + 
				"            <requestCode>NS</requestCode>\r\n" + 
				"            <requestComments>Non-Smoking</requestComments>\r\n" + 
				"        </SpecialRequest>\r\n" + 
				"        <SpecialRequest mfSpecialRequestType=\"SPE\" reservationActionType=\"NEW\">\r\n" + 
				"            <specialRequestRPH>1</specialRequestRPH>\r\n" + 
				"            <requestCode>TSB</requestCode>\r\n" + 
				"            <requestComments>Twin Size Bed</requestComments>\r\n" + 
				"        </SpecialRequest>\r\n" + 
				"    </SpecialRequests>\r\n" + 
				"    <resProfileRPHs>0</resProfileRPHs>\r\n" + 
				"</Reservation>";
		
		
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource src = new InputSource();
		src.setCharacterStream(new StringReader(xml));
		Document doc = builder.parse(src);

   
              String confirmationID = doc.getElementsByTagName("confirmationID").item(0).getTextContent();
              System.out.println("Confirmation ID is:-"+confirmationID);
              
              String StartTime = doc.getElementsByTagName("startTime").item(0).getTextContent();
              System.out.println("startTime is:-"+StartTime);
          
              String originalBookingDate = doc.getElementsByTagName("originalBookingDate").item(0).getTextContent();
              System.out.println("originalBookingDate is:-"+originalBookingDate);
              
              String HotelCode = doc.getElementsByTagName("hotelCode").item(0).getTextContent();
              System.out.println("Hotel Code is:-"+HotelCode);
              
              String BeAmount = doc.getElementsByTagName("comment").item(0).getTextContent();
              System.out.println("BE Amount is:-"+BeAmount);
              
             String creditCardCode = doc.getElementsByTagName("ns2:creditCardCode").item(0).getTextContent();
              System.out.println("creditCardCode is:-"+creditCardCode);
              
              String mfGuaranteeType = doc.getElementsByTagName("mfGuaranteeType").item(0).getTextContent();
              System.out.println("GuaranteeInfo is:-"+mfGuaranteeType);
              
              String PaymentMethod = doc.getElementsByTagName("mfPaymentMethod").item(0).getTextContent();
              System.out.println("PaymentMethod is:-"+PaymentMethod);
             
              
              String Payment = doc.getElementsByTagName("comment").item(1).getTextContent();
              System.out.println("payment details is:-"+Payment); 
              
              
              
              
              
              
           
}
}