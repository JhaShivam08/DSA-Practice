#include <stdio.h>
#include <stdlib.h>

// Structure for a Doubly Linked List Node
struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

// Function to create a new Node
struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;

    return newNode;
}

int main() {

    // Create first Node
    struct Node *head = createNode(1);

    // Create second Node
    struct Node *a = createNode(2);

    // Connect first and second Node
    head->next = a;
    a->prev = head;

    // Create third Node
    struct Node *b = createNode(3);

    // Connect second and third Node
    a->next = b;
    b->prev = a;

    return 0;
}