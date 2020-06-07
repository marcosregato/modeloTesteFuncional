package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import browser.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.EstiloRoupa;

public class ElementPag extends Browser {

	WebDriver driver = getDriver();
	EstiloRoupa estiloRoupa = new EstiloRoupa();
	
	@And("^clicar no botao de pesquisa$")
	public void clickBotaoPesquisar() {
		try {
			WebElement element = driver.findElement(By.xpath(".//*[@name='submit_search']"));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^o usuario acessa o site (.*?)$")
	public void openBrowser(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^o usuario clica aleatóriamente estilo de roupa$")
	public void linkEstiloRoupa() {
		try {

			WebElement element = driver.findElement(By.linkText(estiloRoupa.estiloPopular()));
			element.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@When("^o usuario digitar no campo de pesquisa$")
	public void escreverTxtCampoPesquisar() {
		try {
			WebElement element = driver.findElement(By.xpath(".//*[@placeholder='Search']"));
			element.sendKeys(estiloRoupa.estiloPopular());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@Then("^ordem de roupa$")
	public void selectOrdemProduto() {
		try {
			Select select = new Select(driver.findElement(By.id("selectProductSort")));
			select.selectByValue(new EstiloRoupa().ordemProduto());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@And("^fecha broser do teste$")
	public void fechaBroswer() {
		try {
			if (driver != null)
				driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^o usuario digita a quantidade de roupa (.*?)$")
	public void campoQuantidade(String quantidade) {
		try {
			WebElement element = driver.findElement(By.id("quantity_wanted"));
			element.clear();
			element.sendKeys(quantidade);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@And("^clica no botao Add to card$")
	public void clickBotaoAddToCart() {
		try {
			WebElement element = driver.findElement(By.name("Submit"));
			element.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@And("^clica no botao Proceed To Checkout$")
	public void clickBotaoProceedToCheckout() {
		try {
			WebElement element = driver.findElement(By.xpath(".//*[@title='Proceed to checkout']"));
			if(element.isDisplayed()) {
				element.click();
			}else {
				WebElement element2 = driver.findElement(By.xpath("//a[contains(@href,'controller=order&step=1')]"));
				element2.click();
			}
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}