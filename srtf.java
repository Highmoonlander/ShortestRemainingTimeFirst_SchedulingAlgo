import java.util.Arrays;

class Process {
    int pid;
    int at;
    int bt;

    public Process(int pid, int at, int bt) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
    }
}

public class SRTF {
    public static void calculateWT(Process[] p, int n, int[] wt, int[] ct, int[] tat) {
        int[] rt = new int[n];
        int totalTime = 0, currentTime = 0;
        int sj = -1;

        for (int i = 0; i < n; i++) {
            rt[i] = p[i].bt;
            totalTime += p[i].bt;
        }

        while (totalTime != 0) {
            sj = -1;
            for (int i = 0; i < n; i++) {
                if (currentTime >= p[i].at && (sj == -1 || rt[i] < rt[sj]) && rt[i] != 0) {
                    sj = i;
                }
            }
            if (sj == -1) {
                currentTime++;
                continue;
            }
            currentTime++;
            rt[sj]--;
            totalTime--;

            if (rt[sj] == 0) {
                ct[sj] = currentTime;
                tat[sj] = ct[sj] - p[sj].at;
                wt[sj] = tat[sj] - p[sj].bt;
            }
        }
    }

    public static void calculateAvgTime(int n, int[] wt, int[] tat, float[] awt, float[] atat) {
        for (int i = 0; i < n; i++) {
            *awt += wt[i];
            *atat += tat[i];
        }
    }

    public static void srtf(Process[] p, int n) {
        float awt = 0.0f, atat = 0.0f;
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] ct = new int[n];
        calculateWT(p, n, wt, ct, tat);
        calculateAvgTime(n, wt, tat, &awt, &atat);
        System.out.println("pid\tat\tbt\twt\ttat\tct");
        for (int i = 0; i < n; i++) {
            System.out.println(p[i].pid + "\t" + p[i].at + "\t" + p[i].bt + "\t" + wt[i] + "\t" + tat[i] + "\t" + ct[i]);
        }
        System.out.println("avg wt: " + awt / n);
        System.out.println("avg tat: " + atat / n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        Process[] p = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the arrival and burst time of process " + (i + 1) + ": ");
            int at = scanner.nextInt();
            int bt = scanner.nextInt();
            p[i] = new Process(i + 1, at, bt);
        }
        srtf(p, n);
    }
}
write a description for this in 300 characters
