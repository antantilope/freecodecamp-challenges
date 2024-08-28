

/*

    8.16
        Write a program that tests whether two words are anagrams (permutations of the same letters):
        Enter first word : smartest
        Enter second word : mattress
        The words are anagrams .
        Enter first word : dumbest
        Enter second word : stumble
        The words are not anagrams .
    gcc 8.16.c
*/

#include <stdbool.h>
#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>


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

bool to_lowercase(char *c) {
    for(char *ptr = c; *ptr; ptr++) {
        if(*ptr >= 'A' && *ptr <= 'Z')
            *ptr += 32; // convert to lowercase
        else if(*ptr >= 'a' && *ptr <= 'z')
            continue; // no change needed
        else
            return false; // not a->z letter
    }
    return true;
}


int main()
{   
    int exit_code = 0;

    printf("Enter first word: ");
    char *word1 = read_line_from_stdin();
    printf("Enter second word: ");
    char *word2 = read_line_from_stdin();
    if(!word1 || !word2) {
        fprintf(stderr, "Error reading from stdin\n");
        exit_code = 1;
        goto exit_program;
    }


    // convert to lowercase, reject if not a->z/A->Z letters
    if(!to_lowercase(word1)){
        fprintf(stderr, "Error: word1 must be a->z letters\n");
        exit_code = 1;
        goto exit_program;
    }
    if(!to_lowercase(word2)){
        fprintf(stderr, "Error: word2 must be a->z letters\n");
        exit_code = 1;
        goto exit_program;
    }

    uint32_t word1_letter_counts[26] = {0};
    uint32_t word2_letter_counts[26] = {0};

    for(char *c = word1; *c; c++)
        word1_letter_counts[*c - 'a']++;
    for(char *c = word2; *c; c++)
        word2_letter_counts[*c - 'a']++;

    bool are_anagrams = strlen(word1) == strlen(word2);
    for(uint32_t i = 0; are_anagrams && i < 26; i++)
        are_anagrams = word1_letter_counts[i] == word2_letter_counts[i];

    printf(
        are_anagrams
        ? "The words are anagrams.\n"
        : "The words are not anagrams.\n");


    exit_program:
    if(word1) free(word1);
    if(word2) free(word2);
    return exit_code;
}

