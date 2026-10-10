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

// Push
void push(struct Node **top, int data) {

    struct Node *newNode = createNode(data);

    newNode->next = *top;

    *top = newNode;

    printf("%d pushed into stack\n", data);
}

int main() {

    // Initially stack is empty
    struct Node *top = NULL;

    // Push elements
    push(&top, 10);
    push(&top, 20);
    push(&top, 30);

    return 0;
}