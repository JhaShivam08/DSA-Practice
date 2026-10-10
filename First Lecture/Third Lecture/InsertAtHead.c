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

// Insert Node at Head
struct Node* insertAtHead(struct Node *head, int data) {

    struct Node *newNode = createNode(data);

    // If Linked List is empty
    if (head == NULL) {
        return newNode;
    }

    // Connect new Node with current head
    newNode->next = head;
    head->prev = newNode;

    // Make new Node the head
    head = newNode;

    return head;
}

// Display Linked List
void traverse(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {

        printf("%d ", temp->data);

        temp = temp->next;
    }
}

int main() {

    struct Node *head = createNode(2);

    head->next = createNode(3);
    head->next->prev = head;

    // Insert 1 at Head
    head = insertAtHead(head, 1);

    traverse(head);

    return 0;
}