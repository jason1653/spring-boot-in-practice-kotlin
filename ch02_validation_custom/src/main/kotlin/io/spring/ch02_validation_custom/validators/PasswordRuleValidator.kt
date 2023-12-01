package io.spring.ch02_validation_custom.validators

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.passay.*

// ktlint-disable no-wildcard-imports

class PasswordRuleValidator : ConstraintValidator<Password, String> {
    private val MIN_COMPLEX_RULES = 2
    private val MAX_REPETITIVE_CHARS = 3
    private val MIN_SPECIAL_CASE_CHARS = 1
    private val MIN_UPPER_CASE_CHARS = 1
    private val MIN_LOWER_CASE_CHARS = 1
    private val MIN_DIGIT_CASE_CHARS = 1
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val passwordRules: MutableList<Rule> = mutableListOf()
        passwordRules.add(LengthRule(8, 30))

        val characterCharcteristicsRule = CharacterCharacteristicsRule(
            MIN_COMPLEX_RULES,
            CharacterRule(EnglishCharacterData.Special, MIN_SPECIAL_CASE_CHARS),
            CharacterRule(EnglishCharacterData.UpperCase, MIN_UPPER_CASE_CHARS),
            CharacterRule(EnglishCharacterData.LowerCase, MIN_LOWER_CASE_CHARS),
            CharacterRule(EnglishCharacterData.Digit, MIN_DIGIT_CASE_CHARS),
        )

        passwordRules.add(characterCharcteristicsRule)
        passwordRules.add(RepeatCharactersRule(MAX_REPETITIVE_CHARS))
        val passwordValidator = PasswordValidator(passwordRules)
        val passwordData = PasswordData(value)

        val ruleResult = passwordValidator.validate(passwordData)
        return ruleResult.isValid()
    }
}
