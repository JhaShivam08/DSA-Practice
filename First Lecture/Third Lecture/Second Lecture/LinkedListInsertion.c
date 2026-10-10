#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;

    return newNode;
}

// Insert at Head
struct Node* insertAtHead(struct Node *head, int data) {

    struct Node *newNode = createNode(data);

    if (head == NULL) {
        return newNode;
    }

    newNode->next = head;
    head->prev = newNode;

    head = newNode;

    return head;
}

// Insert at Tail
struct Node* insertAtTail(struct Node *head, int data) {

    struct Node *newNode = createNode(data);

    if (head == NULL) {
        return newNode;
    }

    struct Node *temp = head;

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;

    return head;
}

// Insert at any position
struct Node* insertAtPosition(struct Node *head, int data, int position) {

    // Insert at Head
    if (position == 1) {
        return insertAtHead(head, data);
    }

    struct Node *temp = head;

    for (int i = 1; i < position - 1 && temp != NULL; i++) {
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Invalid Position\n");
        return head;
    }

    struct Node *newNode = createNode(data);

    newNode->next = temp->next;
    newNode->prev = temp;

    if (temp->next != NULL) {
        temp->next->prev = newNode;
    }

    temp->next = newNode;

    return head;
}

// Traversal
void traversal(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {

    struct Node *head = NULL;

    // Insert at Head
    head = insertAtHead(head, 20);

    // Insert at Head
    head = insertAtHead(head, 10);

    // Insert at Tail
    head = insertAtTail(head, 30);

    // Insert at Position 3
    head = insertAtPosition(head, 25, 3);

    traversal(head);

    return 0;
}