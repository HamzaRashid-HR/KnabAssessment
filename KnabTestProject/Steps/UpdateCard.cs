using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using TechTalk.SpecFlow;
using SpecFlow;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace KnabTestProject.Steps
{
    [Binding]
    public class UpdateCard
    {
        //Steps definition
        public static IWebDriver driver = new ChromeDriver();

        [Given("User is logged in with project board")]
        public static void GivenUserIsLoggedInTrelloBoard(string username, string password)
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://trello.com/en/login");

            IWebElement emailBox = driver.FindElement(By.Id("user"));
            emailBox.SendKeys(username);

            IWebElement loginButton = driver.FindElement(By.Id("login"));
            loginButton.Click();
        }

        [Given("Card is on the board")]
        public void CardVisible()
        {
            Assert.IsTrue(driver.FindElement(By.XPath("//*[contains(text(),'New Card 1')]")).Enabled);
        }

        [When("User clicks on Edit option")]
        public void EditCard()
        {
            driver.FindElement(By.ClassName("New Card 1")).Click();
        }

        [Then("Card detail dialogue appears")]
        public void CardDialogue()
        {
            Assert.Equals(driver.FindElement(By.ClassName("window-title")).GetAttribute("innerText"),"New Card 1");
        }

        [When("Update the title")]
        public void UpdateTitle()
        {
            driver.FindElement(By.ClassName("window-title")).Clear();
            driver.FindElement(By.ClassName("window-title")).SendKeys("Updated Card 1");
        }

        [When("Click ‘Save’ button")]
        public void Save()
        {
            driver.FindElement(By.XPath("//input[@type='submit']")).Click();
        }

        [Then("Updated card displays on board")]
        public void ThenTheResultShouldBe(int result)
        {
            Assert.IsTrue(driver.FindElement(By.XPath("//*[contains(text(),'Updated Card 1')]")).Enabled);
        }
    }
}
