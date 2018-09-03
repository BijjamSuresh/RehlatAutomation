package com.automation.rehlat.pages.constructors;


import com.automation.rehlat.Labels;
import com.automation.rehlat.pages.BasePage;
import com.automation.rehlat.pages.bookingPage.BookingPageAndroid;
import com.automation.rehlat.pages.bookingPage.BookingPageIos;
import com.automation.rehlat.pages.flights.FlightsAndroid;
import com.automation.rehlat.pages.flights.FlightsIos;
import com.automation.rehlat.pages.flightsSearchResults.FlightsSearchResultsAndroid;
import com.automation.rehlat.pages.flightsSearchResults.FlightsSearchResultsIos;
import com.automation.rehlat.pages.flightsSimilarOptionsSearchResults.FlightsSimilarOptionsSearchResultsAndroid;
import com.automation.rehlat.pages.flightsSimilarOptionsSearchResults.FlightsSimilarOptionsSearchResultsIos;
import com.automation.rehlat.pages.menu.MenuAndroid;
import com.automation.rehlat.pages.menu.MenuIos;
import com.automation.rehlat.pages.myProfile.MyProfileAndroid;
import com.automation.rehlat.pages.myProfile.MyProfileIos;
import com.automation.rehlat.pages.paymentOptions.PaymentOptionsAndroid;
import com.automation.rehlat.pages.paymentOptions.PaymentOptionsIos;
import com.automation.rehlat.pages.reviewBooking.ReviewBookingAndroid;
import com.automation.rehlat.pages.reviewBooking.ReviewBookingIos;
import com.automation.rehlat.pages.signIn.SignInAndroid;
import com.automation.rehlat.pages.signIn.SignInIos;
import com.automation.rehlat.pages.signUp.SignUpAndroid;
import com.automation.rehlat.pages.signUp.SignUpIos;
import com.automation.rehlat.pages.travellerDetails.TravellerDetailsAndroid;
import com.automation.rehlat.pages.travellerDetails.TravellerDetailsIos;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Assert;

public class PageConstructor {

    public static void initializePageObject(String page, String platform) {

        switch (page) {
            case "signIn":
                if (platform.equals(Labels.ANDROID)) {
                    BasePage.SignInScreen = new SignInAndroid();
                    BaseTest.SignInScreen = new SignInAndroid();

                } else if (platform.equals(Labels.IOS)) {
                    BasePage.SignInScreen = new SignInIos();
                    BaseTest.SignInScreen = new SignInIos();
                }
                break;

            case "flights":
                if (platform.equals(Labels.ANDROID)) {
                    BasePage.FlightsScreen = new FlightsAndroid();
                    BaseTest.FlightsScreen = new FlightsAndroid();

                } else if (platform.equals(Labels.IOS)) {
                    BasePage.FlightsScreen = new FlightsIos();
                    BaseTest.FlightsScreen = new FlightsIos();
                }
                break;

            case "menu":
                if (platform.equals(Labels.ANDROID)) {
                    BasePage.MenuScreen = new MenuAndroid();
                    BaseTest.MenuScreen = new MenuAndroid();

                } else if (platform.equals(Labels.IOS)) {
                    BasePage.MenuScreen = new MenuIos();
                    BaseTest.MenuScreen = new MenuIos();
                }
                break;
            case "signUp":
                if (platform.equals(Labels.ANDROID)) {
                    BasePage.SignUpScreen = new SignUpAndroid();
                    BaseTest.SignUpScreen = new SignUpAndroid();

                } else if (platform.equals(Labels.IOS)) {
                    BasePage.SignUpScreen = new SignUpIos();
                    BaseTest.SignUpScreen = new SignUpIos();
                }
                break;
            case "flightsSearchResults":
                if (platform.equals(Labels.ANDROID)){
                    BasePage.FlightsSearchResultsScreen = new FlightsSearchResultsAndroid();
                    BaseTest.FlightsSearchResultsScreen = new FlightsSearchResultsAndroid();
                } else if (platform.equals(Labels.IOS)){
                    BasePage.FlightsSearchResultsScreen = new FlightsSearchResultsIos();
                    BaseTest.FlightsSearchResultsScreen = new FlightsSearchResultsIos();
                }
                break;
            case "flightsSimilarOptionsSearchResultsScreen":
                if (platform.equals(Labels.ANDROID)){
                    BasePage.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsAndroid();
                    BaseTest.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsAndroid();
                } else if(platform.equals(Labels.IOS)){
                    BasePage.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsIos();
                    BaseTest.FlightsSimilarOptionsSearchResultsScreen = new FlightsSimilarOptionsSearchResultsIos();
            }
            break;
            case "reviewBookingScreen":
                if (platform.equals(Labels.ANDROID)){
                    BasePage.ReviewBookingScreen = new ReviewBookingAndroid();
                    BaseTest.ReviewBookingScreen = new ReviewBookingAndroid();
                }else{
                    BasePage.ReviewBookingScreen = new ReviewBookingIos();
                    BaseTest.ReviewBookingScreen = new ReviewBookingIos();
                }
             break;
            case "bookingPageScreen":
                if (platform.equals(Labels.ANDROID)){
                    BasePage.BookingPageScreen = new BookingPageAndroid();
                    BaseTest.BookingPageScreen = new BookingPageAndroid();
                }else{
                    BasePage.BookingPageScreen = new BookingPageIos();
                    BaseTest.BookingPageScreen = new BookingPageIos();
                }
                break;
            case "travellerDetailsScreen":
                if (platform.equals(Labels.ANDROID)){
                    BasePage.TravellerDetailsScreen = new TravellerDetailsAndroid();
                    BaseTest.TravellerDetailsScreen = new TravellerDetailsAndroid();
                }else{
                    BasePage.TravellerDetailsScreen = new TravellerDetailsIos();
                    BaseTest.TravellerDetailsScreen = new TravellerDetailsIos();
                }
                break;
            case "paymentOptionsScreen":
                if (platform.equals(Labels.ANDROID)){
                    BasePage.PaymentOptionsScreen = new PaymentOptionsAndroid();
                    BaseTest.PaymentOptionsScreen = new PaymentOptionsAndroid();
                }else{
                    BasePage.PaymentOptionsScreen = new PaymentOptionsIos();
                    BaseTest.PaymentOptionsScreen = new PaymentOptionsIos();
                }
                break;
            case "myProfileScreen":
                if (platform.equals(Labels.ANDROID)){
                    BasePage.MyProfileScreen = new MyProfileAndroid();
                    BaseTest.MyProfileScreen = new MyProfileAndroid();
                }else{
                    BasePage.MyProfileScreen = new MyProfileIos();
                    BaseTest.MyProfileScreen = new MyProfileIos();
                }
                break;
            default:
                Assert.fail(page + "screen not found or defined" );
        }
    }
}
