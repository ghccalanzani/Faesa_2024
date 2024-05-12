#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct no{
    char token[20];
    struct no *prox;
};

int main() {
    struct no *p, *head[2];
    int i, tipotoken;
    char tokenLido[20];
    FILE *arquivo;

    for(i=0; i<2; i++){
        head[i] = NULL;
    }
    //Tipo 0 = token tipo de dado (int, float, long e char")
    //Tipo 1 = token valor (0, 0-2147483647)

    arquivo = fopen("input.txt", "r");
    if (arquivo == NULL){
        printf("Não foi possível abrir o arquivo.\n");
        return 1;
    }

    while(fscanf(arquivo, "%[^;];", tokenLido) != EOF){
        p = malloc(sizeof(struct no));
        strcpy(p->token, tokenLido);

        if(strcmp(tokenLido, "int") == 0 || strcmp(tokenLido, "float") == 0 || strcmp(tokenLido, "double") == 0 || strcmp(tokenLido, "char") == 0){
            tipotoken = 0;
        }
        if((strchr(tokenLido, '0') != NULL && strlen(tokenLido) == 1) || atoi(tokenLido) != 0) {
            tipotoken = 1;
        }

        p->prox = head[tipotoken];
        head[tipotoken] = p;
    }

    fclose(arquivo);
    return 0;
}