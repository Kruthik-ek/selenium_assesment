package Day12_assesment_tc1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Assessment12OrangeHRMBase.BaseClass;
import Assessment12OrangeHRMData.ExcelUtility;
import Assessment12OrangeHRMPom.AddVacancyPage;
import Assessment12OrangeHRMPom.DashboardPage;
import Assessment12OrangeHRMPom.RecruitmentPage;
import Assessment12OrangeHRMPom.VacanciesPage;

public class OrangeHRMTest extends BaseClass {

    @Test
    public void OrangeHRm() throws IOException, InterruptedException {

        // Get data from Excel
        Object[][] data = ExcelUtility.getData();

        String vacancyName = (String) data[0][0];

        String jobTitle = (String) data[0][1];

        String description = (String) data[0][2];

        String hiringManager = (String) data[0][3];

        String numberOfPositions = (String) data[0][4];

        // Verify Dashboard
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        Assert.assertTrue(
                dashboardPage.verifyDashboard(),
                "Dashboard is not displayed"
        );

        System.out.println("Dashboard is displayed");

        // Click Recruitment
        RecruitmentPage recruitmentPage =
                new RecruitmentPage(driver);

        recruitmentPage.clickRecruitment();

        System.out.println("Recruitment clicked");

        // Click Vacancies
        recruitmentPage.clickVacancies();

        // Verify Vacancies Page
        VacanciesPage vacanciesPage =
                new VacanciesPage(driver);

        Assert.assertTrue(
                vacanciesPage.verifyVacanciesPage(),
                "Vacancies page is not displayed"
        );

        System.out.println("Vacancies page is displayed");

        // Click Add
        vacanciesPage.clickAddVacancy();

        // Add Vacancy
        AddVacancyPage addVacancyPage =
                new AddVacancyPage(driver);

        // Enter Vacancy Name
        addVacancyPage.enterVacancyName(
                vacancyName
        );

        // Select Job Title
        addVacancyPage.selectJobTitle(
                jobTitle
        );

        // Enter Description
        addVacancyPage.enterDescription(
                description
        );

        // Select Hiring Manager
        addVacancyPage.selectHiringManager(
                hiringManager
        );

        // Enter Number of Positions
        addVacancyPage.enterNumberOfPositions(
                numberOfPositions
        );

        // Click Save
        addVacancyPage.clickSave();

        System.out.println(
                "Vacancy created successfully"
        );
    }
}