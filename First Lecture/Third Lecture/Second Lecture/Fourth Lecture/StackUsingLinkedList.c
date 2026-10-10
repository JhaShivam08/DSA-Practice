#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

// Push
void push(struct Node **top, int data) {
    struct Node *newNode = malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = *top;

    *top = newNode;
}

// Pop
void pop(struct Node **top) {
    if (*top == NULL) {
        printf("Stack is Empty\n");
        return;
    }

    struct Node *temp = *top;
    printf("Popped: %d\n", temp->data);

    *top = (*top)->next;
    free(temp);
}

// Peek
void peek(struct Node *top) {
    if (top == NULL) {
        printf("Stack is Empty\n");
        return;
    }

    printf("Top: %d\n", top->data);
}

// Display
void display(struct Node *top) {
    while (top != NULL) {
        printf("%d -> ", top->data);
        top = top->next;
    }
    printf("NULL\n");
}

int main() {
    struct Node *top = NULL;

    push(&top, 10);
    push(&top, 20);
    push(&top, 30);

    display(top);

    peek(top);

    pop(&top);

    display(top);

    return 0;
}