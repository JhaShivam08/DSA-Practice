#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

// Create Node
struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;

    return newNode;
}

// Peek
void peek(struct Node *top) {

    if (top == NULL) {
        printf("Stack is Empty\n");
        return;
    }

    printf("Top element = %d\n", top->data);
}

int main() {

    // Create stack
    struct Node *top = NULL;

    // Add elements
    top = createNode(10);
    top->next = createNode(20);
    top->next->next = createNode(30);

    // Peek
    peek(top);

    return 0;
}