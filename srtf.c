#include<stdio.h>

struct process{
    int pid;
    int at,bt;
};

void calculate_wt(struct process* p,int n,int* wt,int* ct,int* tat){
    int rt[n];
    int totalTime = 0,currentTime = 0;
    int sj = -1;

    for(int i = 0;i < n;i++){
        rt[i] = p[i].bt;
        totalTime += p[i].bt;
    }

    while(totalTime != 0){
            sj = -1;
        for(int i = 0;i < n;i++){
            if(currentTime >= p[i].at && (sj == -1 || rt[i] < rt[sj]) && rt[i] != 0){
                sj = i;
            }
        }
        if(sj == -1){
            currentTime++;
            continue;
        }
        currentTime++;
        rt[sj]--;
        totalTime--;

        if(rt[sj] == 0){
            ct[sj] = currentTime;
            tat[sj] = ct[sj] - p[sj].at;
            wt[sj] = tat[sj] - p[sj].bt;
        }
    }
}

void calculate_avg_time(int n,int* wt,int* tat,float* awt,float* atat){
    for(int i = 0;i < n;i++){
        *awt += wt[i];
        *atat += tat[i];
    }
}

void srtf(struct process* p,int n){
    float awt = 0.0, atat = 0.0;
    int wt[n],tat[n],ct[n];
    calculate_wt(p,n,wt,ct,tat);
    calculate_avg_time(n,wt,tat,&awt,&atat);
    printf("pid\tat\tbt\twt\ttat\tct\n");
    for(int i = 0;i < n;i++){
        printf("%d\t%d\t%d\t%d\t%d\t%d\n",p[i].pid,p[i].at,p[i].bt,wt[i],tat[i],ct[i]);
    }
    printf("avg wt: %.2f\n",awt/n);
    printf("avg tat: %.2f\n",atat/n);
}

int main(){
    int n;
    printf("Enter the number of processes: ");
    scanf("%d",&n);
    struct process p[n];
    for(int i = 0;i < n;i++){
        printf("Enter the arrival and burst time of process %d: ", i+1);
        scanf("%d %d",&p[i].at,&p[i].bt);
        p[i].pid = i+1;
    }
    srtf(p,n);
}