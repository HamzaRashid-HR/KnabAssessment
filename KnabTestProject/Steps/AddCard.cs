using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using TechTalk.SpecFlow;
using SpecFlow;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace KnabTestProject.Steps
{
    [Binding]
    public class AddCard
    {
        //Steps definition

        public static IWebDriver driver;

        [Given("User is logged in with project board")]
        public static void GivenUserIsLoggedInTrelloBoard(string username, string password)
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://trello.com/en/login");

            IWebElement emailBox = driver.FindElement(By.Id("user"));
            emailBox.SendKeys(username);

            IWebElement passBox = driver.FindElement(By.Id("password"));
            emailBox.SendKeys(username);

            IWebElement loginButton = driver.FindElement(By.Id("login"));
            loginButton.Click();
        }

        [When("User clicks on Add card")]
        public static void UserAddCard()
        {
            Assert.IsTrue(driver.FindElement(By.ClassName("js-add-a-card")).Enabled);
            driver.FindElement(By.ClassName("js-add-a-card")).Click();
        }

        [Then("Title text box appears")]
        public void TitleTextBox()
        {
            Assert.IsTrue(driver.FindElement(By.Id("card-composer")).Enabled);
        }

        [When("Insert title of the card")]
        public static void InsertTitle(string title)
        {
            driver.FindElement(By.Id("card-composer")).SendKeys("New Card 1");
        }

        [When ("Save details of card")]
        public static void Save()
        {
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
        }

        [Then("New card displays on board")]
        public static void CardVisible()
        {
            Assert.IsTrue(driver.FindElement(By.XPath("//*[contains(text(),'New Card 1')]")).Enabled);
        }
    }
}
