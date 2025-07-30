public class CourseScheduler {

    public static int maxNonOverlappingCourses(int[][] courses) {
        // Първо сортираме курсовете по крайно време (възходящо)
        sortByEndTime(courses);

        int count = 0;
        int lastEndTime = -1;

        for (int i = 0; i < courses.length; i++) {
            int start = courses[i][0];
            int end = courses[i][1];

            if (start >= lastEndTime) {
                count++;
                lastEndTime = end;
            }
        }

        return count;
    }

    // Ръчна реализация на сортиране по крайно време (bubble sort)
    public static void sortByEndTime(int[][] courses) {
        for (int i = 0; i < courses.length - 1; i++) {
            for (int j = 0; j < courses.length - i - 1; j++) {
                if (courses[j][1] > courses[j + 1][1]) {
                    // Размяна на целите редове (двойки)
                    int tempStart = courses[j][0];
                    int tempEnd = courses[j][1];
                    courses[j][0] = courses[j + 1][0];
                    courses[j][1] = courses[j + 1][1];
                    courses[j + 1][0] = tempStart;
                    courses[j + 1][1] = tempEnd;
                }
            }
        }
    }

    // Тестове
    public static void main(String[] args) {
        System.out.println(maxNonOverlappingCourses(new int[][]{{9, 11}, {10, 12}, {11, 13}, {15, 16}})); // 3
        System.out.println(maxNonOverlappingCourses(new int[][]{{19, 22}, {17, 19}, {9, 12}, {9, 11}, {15, 17}, {15, 17}})); // 4
        System.out.println(maxNonOverlappingCourses(new int[][]{{19, 22}})); // 1
        System.out.println(maxNonOverlappingCourses(new int[][]{{13, 15}, {13, 17}, {11, 17}})); // 1
    }
}
