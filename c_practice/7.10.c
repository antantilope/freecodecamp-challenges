

/*

7.10
    Write a program that counts the number of vowels (a, e, i, o, and u) in a sentence:
    Enter a sentence : And that ’ s the way it is .
    Your sentence contains 6 vowels .

    gcc 7.10.c \
        -Wall -Wextra -Wfloat-equal -Wno-unused-variable -pedantic -Wno-unused-parameter -g \
        -o vowel_count
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


bool char_is_vowel(char c)
{
    return (
           c == 'a' || c == 'A'
        || c == 'e' || c == 'E'
        || c == 'i' || c == 'I'
        || c == 'o' || c == 'O'
        || c == 'u' || c == 'U'
    );
}


int main()
{   
    int exit_code = 0;

    printf("Enter a sentence: ");
    char *sentence = read_line_from_stdin();
    if(!sentence) {
        fprintf(stderr, "Error reading from stdin\n");
        exit_code = 1;
        goto exit_program;
    }

    uint32_t vowel_count = 0;
    for (char *ptr = sentence; *ptr; ptr++)
        vowel_count += char_is_vowel(*ptr) ? 1 : 0;

    printf("Your sentence contains %u vowels.\n", vowel_count);
    
    exit_program:
    if(sentence) free(sentence);
    return exit_code;
}

