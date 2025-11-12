package ie.atu.sw;

@FunctionalInterface
public interface MediaFilter {
	boolean where(Playable p);
}
