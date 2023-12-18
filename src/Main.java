import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

// Interface  Set
interface Lab07Set<T> extends Set<T> {
}

// Implement Set ใช้ HashMap
abstract class Lab07HashSet<T> implements Lab07Set<T> {
    // ใช้ HashMap
    private final HashMap<T, Object> map;

    // ค่า default ที่จะให้กับทุกรายการใน Set
    private static final Object DUMMY = new Object();

    // Constructor
    public Lab07HashSet() {
        map = new HashMap<>();
    }

    // เพิ่มสมาชิกเข้า Set
    @Override
    public boolean add(T element) {
        // ใส่ element เป็น key ใน HashMap และให้ value เป็น DUMMY
        return map.put(element, DUMMY) == null;
    }

    // ลบสมาชิกจาก Set
    @Override
    public boolean remove(Object element) {
        // ลบ key จาก HashMap
        return map.remove(element) != null;
    }

    // ตรวจสอบว่า Set มีสมาชิกมั้ยยย
    @Override
    public boolean contains(Object element) {
        // ตรวจสอบว่า key มีใน HashMap หรือไม่
        return map.containsKey(element);
    }

    // คืนค่าจำนวนสมาชิกใน Set
    @Override
    public int size() {
        // คืนค่าจำนวน key ใน HashMap
        return map.size();
    }

    // ตรวจสอบว่า Set ว่างหรือไม่
    @Override
    public boolean isEmpty() {
        // ตรวจสอบว่า HashMap ว่างหรือไม่
        return map.isEmpty();
    }

    // ลบทุกรายการออกจาก Set
    @Override
    public void clear() {
        // ลบทุกรายการใน HashMap
        map.clear();
    }

    // คืนค่า Iterator สำหรับ Set
    @Override
    public Iterator<T> iterator() {
        // คืนค่า Iterator ของ key ใน HashMap
        return map.keySet().iterator();
    }

    // คืนค่า Array ของ Elements ใน Set
    @Override
    public Object[] toArray() {
        // ไม่ต้อง implement ในที่นี้
        return null;
    }

    // คืนค่า Array ของ Elements ใน Set
    @Override
    public <T1> T1[] toArray(T1[] a) {
        // ไม่ต้อง implement
        return null;
    }

    // ไม่ต้อง implement methods ที่ไม่ได้ถูกกล่าวถึง
}

// ทดสอบความถูกต้องของ Set
class Lab07 {
    public static void main(String[] args) {
        // สร้าง Lab07HashSet
        Lab07Set<String> set = new Lab07HashSet<>() {
            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }
        };

        // เพิ่มสมาชิก
        set.add("A");
        set.add("B");
        set.add("C");

        // ตรวจสอบความถูกต้อง
        System.out.println("Contains A: " + set.contains("A")); // ต้องได้ true
        System.out.println("Contains D: " + set.contains("D")); // ต้องได้ false

        // ลบสมาชิก
        set.remove("B");

        // ตรวจสอบความถูกต้อง
        System.out.println("Contains B: " + set.contains("B")); // ต้องได้ false

        // แสดงจำนวนสมาชิก
        System.out.println("Size: " + set.size()); // ต้องได้ 2

        // ลบทุกรายการ
        set.clear();

        // ตรวจสอบความถูกต้อง
        System.out.println("Size after clear: " + set.size()); // ต้องได้ 0
    }
}