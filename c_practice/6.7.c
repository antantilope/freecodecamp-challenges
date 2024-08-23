

/*

6.7
    Write a program that asks the user to enter a U.S. dollar amount and then shows how to pay that amount
    using the smallest number of $20, $10, $5, and $1 bills:
    Enter a dollar amount : 93
    $20 bills : 4 , $10 bills : 1 , $5 bills : 0 , $1 bills : 3
    Hint: Divide the amount by 20 to determine the number of $20 bills needed, and then reduce the amount
    by the total value of the $20 bills. Repeat for the other bill sizes. Be sure to use integer values throughout,
    not floating-point numbers


    gcc 6.7.c \
        -Wall -Wextra -Wfloat-equal -Wno-unused-variable -pedantic -Wno-unused-parameter -g \
        -o dollar_bills
        
*/

#include <stdbool.h>
#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>


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

int main()
{   
    int exit_code = 0;
    char buffer[32];

    printf("Enter a dollar amount: ");
    bool ok = read_line_from_stdin(buffer, sizeof (buffer));
    if (!ok) {
        fprintf(stderr, "Error reading from stdin\n");
        exit_code = 1;
        goto exit_program;
    }
    uint32_t dollar_amount = strtoul(buffer, NULL, 10);


    uint32_t twenty_bills_ct = dollar_amount / 20;
    dollar_amount -= twenty_bills_ct * 20;

    uint32_t ten_bills_ct = dollar_amount / 10;
    dollar_amount -= ten_bills_ct * 10;

    uint32_t five_bills_ct = dollar_amount / 5;
    dollar_amount -= five_bills_ct * 5;

    uint32_t one_bills_ct = dollar_amount;


    printf(
        "$20 bills:%u\n$10 bills:%u\n$5  bills:%u\n$1  bills:%u\n",
        twenty_bills_ct,
        ten_bills_ct,
        five_bills_ct,
        one_bills_ct
    );
    
    exit_program:
    return exit_code;
}

