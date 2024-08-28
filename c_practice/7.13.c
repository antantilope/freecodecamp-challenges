

/*

    7.13
        Write a program that calculates the average word length for a sentence:
        Enter a sentence : It was deja vu all over again .
        Average word length : 3.4
        For simplicity, your program should consider a punctuation mark to be part of the word to which it is
        attached. Display the average word length to one decimal place
    gcc 7.13.c
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
        if(ix == buff_size) {
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

    uint32_t
        letter_count = 0,
        word_count = 0;
    
    bool in_word = false;

    for (char *ptr = sentence; *ptr; ptr++) {
        char c = *ptr;
        if(c == ' ') {
            if(in_word) {
                in_word = false;
                word_count++;
            }
            continue; // ignore extra spaces
        }
        in_word = true;
        letter_count++;
    }
    if(in_word) word_count++; // count last word if string ends with a non space.

    // printf("letter_count: %u\n", letter_count);
    // printf("word_count: %u\n", word_count);

    double average_word_length = (double)letter_count / (double)word_count;
    printf("Average word length: %.4f\n", average_word_length);

    exit_program:
    if(sentence) free(sentence);
    return exit_code;
}

