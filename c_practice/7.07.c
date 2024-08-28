
/*

This is not working yet....

7.7
    Write a program that allows the user to enter two fractions and add, subtract, multiply, or divide these
    two fractions (by entering either +, -, *, or / between the fractions):
    Enter two fractions separated by an operator (+ , -, * , /): 1/2+1/4
    The result is 6/8.

    gcc 7.7.c \
        -Wall -Wextra -Wfloat-equal -Wno-unused-variable -pedantic -Wno-unused-parameter -g \
        -o fraction_calculator

*/

#include <stdbool.h>
#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>


#define NOT_IMPLEMENTED(msg) do{fprintf(stderr, "NotImplemented line: %d: %s\n", __LINE__, msg); exit(1); } while(0)

bool read_line_from_stdin(char *buffer, uint32_t size)
{
    /* Pull chars from stdin until a newline is found or the buffer is full.
       returns true if a newline was found before the buffer is full, otherwise returns false.
    */
    uint32_t ix = 0;
    char c;
    while(ix < size) {
        if ((c = getchar()) == '\n') 
            return buffer[ix] = '\0', true;
        buffer[ix++] = c;
    }
    return false;
}

typedef struct fraction_t {
    int64_t numerator;
    int64_t denominator;
} fraction_t;

enum OPERATOR {
    OPERATOR_ADD = '+',
    OPERATOR_SUBTRACT = '-',
    OPERATOR_MULTIPLY = '*',
    OPERATOR_DIVIDE = '/'
};

void print_fraction(fraction_t *fraction){
    printf("fraction: %ld/%ld\n", fraction->numerator, fraction->denominator);
}

bool is_digit(char c) {
    return c >= '0' && c <= '9';
}

bool is_operator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}

bool is_null_terminator(char c) {
    return !c;
}

enum PARSER_STATE {
    PARSER_STATE_LEFT_OPERAND_NUMERATOR,
    PARSER_STATE_LEFT_OPERAND_DENOMINATOR,
    PARSER_STATE_OPERATOR,
    PARSER_STATE_RIGHT_OPERAND_NUMERATOR,
    PARSER_STATE_RIGHT_OPERAND_DENOMINATOR
};



int main()
{   
    int exit_code = 0;

    printf("Enter two fractions separated by an operator (+ , -, * , /): ");
    char buffer[64];
    if (!read_line_from_stdin(buffer, sizeof (buffer))) {
        fprintf(stderr, "Error reading from stdin\n");
        exit_code = 1;
        goto exit_program;
    }
    uint32_t buff_len = strlen(buffer);
    fraction_t left_operand;
    fraction_t right_operand;
    enum OPERATOR operator;

    uint32_t buff_ix = 0;
    char tmp[64];
    uint32_t tmp_ix = 0;

    // Left operand numerator
    while(buff_ix < buff_len) {
        char c = buffer[buff_ix];
        if(is_digit(c)) {
            tmp[tmp_ix++] = c;
            buff_ix++;
            continue;
        } else if(c == ' ') {
            buff_ix++;
            continue;
        }
        else if(c == '/') {
            break;
            buff_ix++;
        }
        else NOT_IMPLEMENTED("Expected digit or /");
    }
    tmp[tmp_ix] = '\0';
    printf("tmp: %s\n", tmp);
    left_operand.numerator = strtoll(tmp, NULL, 10);

    // Left operand demonimator
    tmp_ix = 0;
    while(1) {
        char c = buffer[buff_ix];
        printf("c: %c\n", c);
        if(is_digit(c)) {
            tmp[tmp_ix++] = c;
            buff_ix++;
            continue;
        } else if(c == ' ') {
            buff_ix++;
            continue;
        }
        else if(is_operator(c)) {
            break;
        }
        else NOT_IMPLEMENTED("Expected digit or /");
    }
    tmp[tmp_ix] = '\0';
    printf("tmp: %s\n", tmp);
    left_operand.denominator = strtoll(tmp, NULL, 10);
    print_fraction(&left_operand);

    // Operator
    while(1) {
        char c = buffer[buff_ix];
        if(is_operator(c)) {
            if(c == '+') operator = OPERATOR_ADD;
            else if(c == '-') operator = OPERATOR_SUBTRACT;
            else if(c == '*') operator = OPERATOR_MULTIPLY;
            else if(c == '/') operator = OPERATOR_DIVIDE;
            else NOT_IMPLEMENTED("Expected operator");
            buff_ix++;
            break;
        } else if(c == ' ') {
            buff_ix++;
            continue;
        }
        else NOT_IMPLEMENTED("Expected operator");
    }


    // Right operand numerator
    tmp_ix = 0;
    while(1) {
        char c = buffer[buff_ix];
        printf("c: %c\n", c);
        if(is_digit(c)) {
            tmp[tmp_ix++] = c;
            buff_ix++;
            continue;
        } else if(c == ' ') {
            buff_ix++;
            continue;
        }
        else if(c == '/') {
            break;
            buff_ix++;
        }
        else NOT_IMPLEMENTED("Expected digit or /");
    }
    tmp[tmp_ix] = '\0';
    right_operand.numerator = strtoll(tmp, NULL, 10);

    // right operand demonimator
    tmp_ix = 0;
    while(1) {
        char c = buffer[buff_ix];
        if(is_digit(c)) {
            tmp[tmp_ix++] = c;
            buff_ix++;
            continue;
        } else if(c == ' ') {
            buff_ix++;
            continue;
        }
        else if(!c) {
            break;
            buff_ix++;
        }
        else NOT_IMPLEMENTED("Expected digit or /");
    }
    tmp[tmp_ix] = '\0';
    right_operand.denominator = strtoll(tmp, NULL, 10);
    

    print_fraction(&left_operand);
    printf(" %c ", operator);
    print_fraction(&right_operand);


    exit_program:
    return exit_code;
}
