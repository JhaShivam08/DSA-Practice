#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

// Create a new Node
struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;

    return newNode;
}

// Traverse the Linked List
void traverse(struct Node *head) {

    // If Linked List is empty
    if (head == NULL) {
        return;
    }

    struct Node *temp = head;

    // Move through the Linked List
    while (temp != NULL) {

        printf("%d ", temp->data);

        temp = temp->next;
    }
}

int main() {

    struct Node *head = createNode(1);
    struct Node *a = createNode(2);
    struct Node *b = createNode(3);

    head->next = a;
    a->prev = head;

    a->next = b;
    b->prev = a;

    traverse(head);

    return 0;
}