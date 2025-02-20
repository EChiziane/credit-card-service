package com.buildrun.creditcardservice.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan{
        @Test
        void shouldBeTrueWhenIncomeIsEqual(){
            var customer= new Customer(
                    "Joel Langa",
                    "123.456.89",
                    3000.0,
                    1000);

        assertTrue(customer.isIncomeEqualOrGreaterThan(3000.0));

        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThan(){
            var customer= new Customer(
                    "Joel Langa",
                    "123.456.89",
                    3000.0,
                    1000);

            assertTrue(customer.isIncomeEqualOrGreaterThan(2000.0));

        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThan(){
            var customer= new Customer(
                    "Joel Langa",
                    "123.456.89",
                    3000.0,
                    1000);

            assertFalse(customer.isIncomeEqualOrGreaterThan(4000.0));

        }

    }

}