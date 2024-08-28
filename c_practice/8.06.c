

/*

    8.6
        The prototypical Internet newbie is a fellow named B1FF, who has a unique way of writing messages.
        Write a “B1FF filter” that reads a message entered by the user and translates it into B1FF-speak:
        Enter message : Hey dude , C is rilly cool
        In B1FF - speak : H3Y DUD3 , C 15 R1LLY C00L !!!!!!!!!!
        Your program should convert the message to upper-case letters, substitute digits for certain letters (A→4,
        B→8, E→3, I→1, O→0, S→5), and then append 10 or so exclamation marks.
        There is a hint in the original specification in the book if needed.
    gcc 8.06.c
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

char translate(char c) {
    if(c >= 'a' && c <= 'z')
        c -= 32; // convert to uppercase

    switch(c) {
        case 'A': return '4';
        case 'B': return '8';
        case 'E': return '3';
        case 'I': return '1';
        case 'O': return '0';
        case 'S': return '5';
        default:  return c;
    }
}


int main()
{   
    int exit_code = 0;

    printf("Enter message: ");
    char *user_input = read_line_from_stdin();
    if(!user_input) {
        fprintf(stderr, "Error reading from stdin\n");
        exit_code = 1;
        goto exit_program;
    }

    for(char *c = user_input; *c; c++)
        *c = translate(*c);

    printf("In B1FF-speak: %s!!!!!!!!!!\n", user_input);

    exit_program:
    if(user_input) free(user_input);
    return exit_code;
}

