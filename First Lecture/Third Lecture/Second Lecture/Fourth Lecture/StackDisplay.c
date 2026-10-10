#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node* createNode(int data) {
    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;

    return newNode;
}

void display(struct Node *top) {

    if (top == NULL) {
        printf("Stack is Empty\n");
        return;
    }

    struct Node *temp = top;

    printf("Stack: ");

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {

    struct Node *top = NULL;

    top = createNode(10);
    top->next = createNode(20);
    top->next->next = createNode(30);

    display(top);

    return 0;
}