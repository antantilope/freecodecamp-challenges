

/*

    8.2
        Write a program that prints a table showing how many times does each digit (0-9) appear in a given
        integer number:
        Enter a number : 41271092
        Digit :       0 1 2 3 4 5 6 7 8 9
        Occurrences : 1 2 2 0 1 0 0 1 0 1
    gcc 8.2.c
*/

#include <stdbool.h>
#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>


char* read_line_from_stdin()
{
    // this function mimics POSIX getline, should be portable...

    /* Pull chars from stdin until a newline is found
       Returns dynamically allocated buffer containing the line read from stdin.
       This buffer must be freed by the caller.
    */
    uint32_t buff_size = 32;
    char *buffer = malloc(buff_size);
    if(!buffer) return NULL;

    uint32_t ix = 0;
    char c;
    while(true) {
        if(ix == buff_size - 2) {
            buff_size *= 2;
            if(buff_size >= 0xFFFFFFFF) return NULL;

            void *expanded = realloc(buffer, buff_size);
            if(!expanded) return NULL;
            buffer = expanded;
        }
        if ((c = getchar()) == '\n') 
            return buffer[ix] = '\0', buffer;

        buffer[ix++] = c;
    }
}

int parse_char_to_int(char c) {
    if(c < '0' || c > '9') {
        fprintf(stderr, "Error: char must be a ascii number\n");
        exit(1);
    }
    return c - '0';
}


int main()
{   
    int exit_code = 0;

    printf("Enter a number: ");
    char *user_input = read_line_from_stdin();
    if(!user_input) {
        fprintf(stderr, "Error reading from stdin\n");
        exit_code = 1;
        goto exit_program;
    }
    for(char *c = user_input; *c; c++) {
        if(*c < '0' || *c > '9') {
            fprintf(stderr, "Error: input must be a number\n");
            exit_code = 1;
            goto exit_program;
        }
    }

    uint32_t digit_counts[10] = {0};
    for(char *c = user_input; *c; c++)
        digit_counts[parse_char_to_int(*c)]++;

    printf("Digit :       0 1 2 3 4 5 6 7 8 9\n");
    printf("Occurrences : ");
    for(uint32_t i = 0; i < 10; i++)
        printf("%u ", digit_counts[i]);
    printf("\n");


    exit_program:
    if(user_input) free(user_input);
    return exit_code;
}

