package cc.jianminhuang.day25.service.impl

import cc.jianminhuang.day25.data.`do`.User
import cc.jianminhuang.day25.data.dao.UserDao
import cc.jianminhuang.day25.data.enu.Gender
import io.cucumber.java.en.And
import io.cucumber.java.en.But
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.internal.verification.Times
import org.springframework.data.domain.PageRequest
import java.util.Optional

class UserServiceImplTests {

    private val pageRequest = PageRequest.of(0, 10)
    private lateinit var queryByPageRequest: List<User>
    private val userDao = Mockito.mock(UserDao::class.java)
    private val userService = UserServiceImpl(userDao)
    private var id: Long = 0
    private lateinit var firstName: String
    private lateinit var phone: String
    private lateinit var user: User
    private lateinit var lastName: String
    private var age: Int = 0
    private lateinit var gender: Gender
    private lateinit var email: String

    @Given("End user pass the page request")
    fun endUserPassThePageRequest() {
        BDDMockito.given(userDao.findAll()).willReturn(
            listOf(User(1, "Vincent", "Huang", 18, Gender.BOY, "aaa@trc.com", "+886 987 234 567")),
            listOf(User(2, "Vincent", "Wu", 20, Gender.OTHER, "aaa@uyt.com", "+886 922 244 567"))
        )
    }

    @When("Query with page request")
    fun queryWithPageRequest() {
        queryByPageRequest = userService.query(pageRequest)
    }

    @Then("User list size should greater than {int}")
    fun userListSizeShouldGreaterThan(arg0: Int) {
        Assertions.assertThat(queryByPageRequest.size > arg0).isTrue
    }

    @Given("End user pass id {int}")
    fun endUserPassId(arg0: Int) {
        id = arg0.toLong()
        BDDMockito.given(userDao.findById(id)).willReturn(
            Optional.of(User(arg0.toLong(), "Vincent", "Huang", 18, Gender.BOY, "aaa@trc.com", "+886 987 234 567"))
        )
    }

    @When("Query by id {int}")
    fun queryById(arg0: Int) {
        user = userService.queryById(arg0.toLong())
    }

    @Then("User id should be {int}")
    fun userIdShouldBe(arg0: Int) {
        Assertions.assertThat(user.id).isEqualTo(arg0.toLong())
    }

    @Given("End user pass first name {string}")
    fun endUserPassFirstName(arg0: String?) {
        firstName = arg0!!
        BDDMockito.given(userDao.findByFirstName(firstName, pageRequest)).willReturn(
            listOf(User(1, "Cassell", "Huang", 18, Gender.BOY, "aaa@trc.com", "+886 987 234 567")),
            listOf(User(2, "Cassell", "Wu", 20, Gender.OTHER, "aaa@uyt.com", "+886 922 244 567"))
        )
    }

    @When("Query by first name {string} and page request")
    fun queryByFirstNameAndPageRequest(arg0: String?) {
        queryByPageRequest = userService.findByFirstName(firstName, pageRequest)
    }

    @Given("End user pass phone {string}")
    fun endUserPassPhone(arg0: String?) {
        phone = arg0!!
        BDDMockito.given(userDao.findByPhone(phone)).willReturn(
            Optional.of(User(1, "Cassell", "Huang", 18, Gender.BOY, "aaa@trc.com", "+886 987 234 567"))
        )
    }

    @When("Query by phone {string}")
    fun queryByPhone(arg0: String?) {
        user = userService.findByPhone(arg0!!)
    }

    @Then("User id should not null")
    fun userIdShouldNotNull() {
        Assertions.assertThat(user.id).isNotNull
    }

    @And("End user pass last name {string}")
    fun endUserPassLastName(arg0: String?) {
        lastName = arg0!!
    }

    @And("End user pass age {int}")
    fun endUserPassAge(arg0: Int) {
        age = arg0
    }

    @And("End user pass gender {string}")
    fun endUserPassGender(arg0: String?) {
        gender = Gender.valueOf(arg0!!)
    }

    @And("End user pass e-mail {string}")
    fun endUserPassEMail(arg0: String?) {
        email = arg0!!
        BDDMockito.given(userDao.save(User(null, firstName, lastName, age, gender, email, phone))).willReturn(
            User(22, firstName, lastName, age, gender, email, phone)
        )
    }

    @When("Add")
    fun add() {
        user = userService.add(User(null, firstName, lastName, age, gender, email, phone))
    }

    @But("End user first name should be {string}")
    fun endUserFirstNameShouldBe(arg0: String?) {
        Assertions.assertThat(user.firstName).isEqualTo(arg0!!)
    }

    @But("End user last name should be {string}")
    fun endUserLastNameShouldBe(arg0: String?) {
        Assertions.assertThat(user.lastName).isEqualTo(arg0!!)
    }

    @But("End user age should be {int}")
    fun endUserAgeShouldBe(arg0: Int) {
        Assertions.assertThat(user.age).isEqualTo(arg0)
    }

    @But("End user gender should be {string}")
    fun endUserGenderShouldBe(arg0: String?) {
        Assertions.assertThat(user.gender).isEqualTo(Gender.valueOf(arg0!!))
    }

    @But("End user e-mail should be {string}")
    fun endUserEMailShouldBe(arg0: String?) {
        Assertions.assertThat(user.email).isEqualTo(arg0!!)
    }

    @But("End user phone should be {string}")
    fun endUserPhoneShouldBe(arg0: String?) {
        Assertions.assertThat(user.phone).isEqualTo(arg0!!)
    }

    @When("Modify age {int} by id {int}")
    fun modifyAgeById(arg0: Int, arg1: Int) {
        BDDMockito.given(userDao.findById(arg1.toLong())).willReturn(
            Optional.of(User(arg1.toLong(), "Cassell", "Huang", 18, Gender.BOY, "aaa@trc.com", "+886 987 234 567"))
        )
        BDDMockito.given(
            userDao.save(
                User(
                    arg1.toLong(),
                    "Cassell",
                    "Huang",
                    age,
                    Gender.BOY,
                    "aaa@trc.com",
                    "+886 987 234 567"
                )
            )
        ).willReturn(
            User(
                arg1.toLong(),
                "Cassell",
                "Huang",
                age,
                Gender.BOY,
                "aaa@trc.com",
                "+886 987 234 567"
            )
        )
        user = userService.modifyAgeById(arg0, arg1.toLong())
    }

    @When("Remove by id {int}")
    fun removeById(arg0: Int) {
        userService.removeById(arg0.toLong())
    }

    @Then("Verify id {int} should be null")
    fun verifyIdShouldBeNull(arg0: Int) {
        verify(userDao).deleteById(arg0.toLong())
    }
}