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

    // Allocate memory for new Node
    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    // Store data
    newNode->data = data;

    // Initially next is NULL
    newNode->next = NULL;

    // Initially previous is NULL
    newNode->prev = NULL;

    return newNode;
}

// Function to traverse the Linked List
void traversal(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {

        printf("%d <-> ", temp->data);

        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {

    // Create first Node
    struct Node *head = createNode(10);

    // Create second Node
    struct Node *second = createNode(20);

    // Connect first and second Node
    head->next = second;
    second->prev = head;

    // Create third Node
    struct Node *third = createNode(30);

    // Connect second and third Node
    second->next = third;
    third->prev = second;

    // Traverse the Linked List
    traversal(head);

    return 0;
}