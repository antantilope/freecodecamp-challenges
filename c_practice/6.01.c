

/*

6.1
    Write a program that finds the largest in a series of numbers entered by the user. The program must
    prompt the user to enter numbers one by one. When the user enters 0 or a negative number, the program
    must display the largest nonnegative number entered:
    Enter a number : 60
    Enter a number : 4.89
    Enter a number : 100.62
    Enter a number : 0
    The largest number entered was 100.62
    Notice that the numbers aren’t necessarily integers.


    gcc \
        6.1.c -Wall -Wextra -Wfloat-equal -Wno-unused-variable -pedantic -Wno-unused-parameter -g \
        -o largest_number
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
    while(ix < size - 1) {
        if ((c = getchar()) == '\n') 
            return buffer[ix] = '\0', true;
        buffer[ix++] = c;
    }
    return false;
}

int main()
{   
    int exit_code = 0;
    double max = 0;
    double num;
    char buffer[32];

    while (true) {
        printf("Enter a number: ");

        bool ok = read_line_from_stdin(buffer, sizeof (buffer));
        if (!ok) {
            fprintf(stderr, "Error reading from stdin\n");
            exit_code = 1;
            goto exit_program;
        }

        num = atof(buffer);

        if(num <= 0) break;
        if(num > max) max = num;
    }

    printf("The largest number entered was %f\n", max);

    exit_program:
    return exit_code;
}

